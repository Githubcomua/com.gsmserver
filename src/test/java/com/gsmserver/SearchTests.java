package com.gsmserver;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static java.nio.channels.SocketChannel.open;

public class SearchTests {

    @Test
    void searchProductByTitle() {
        Selenide.open("https://gsmserver.com/");

        var productName = "Z3X Easy-Jtag Plus BGA-254 2-in-1 eMMC/UFS Socket Adapter";
        var productId = "872994";

        $("[name='searchword']").val(productName).pressEnter();
        $(".col-12").shouldHave(Condition.text("productName"));

        findProductById(productId).$("product-info_title").shouldHave(text(productName));
        findProductById(productId).$("[data-action-click='site,card.add']").click();
        findProductById(productId).$(".in-cart").click();

        $("#cart h1").shouldHave(text("Cart"));

        $$("#,cart tr[data-product-id").shouldHave(CollectionCondition.size(1));
        findProductById(productId).$(".product-title").shouldHave(text(productName));

    }

    private SelenideElement findProductById(String productId) {
        return $(by("data-product-id", productId));
    }

}
