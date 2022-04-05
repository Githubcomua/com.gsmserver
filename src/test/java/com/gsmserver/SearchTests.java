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
        var productId = "886748";

        $("[name='searchword']").val(productName).pressEnter();
        $(".col-12").shouldHave(text(productName));

        $(".pr-t_link").shouldHave(text(productName));
        $(".btn--add-to-cart").click();
        $("[space*='cart']").click();

        //$("#cart h1").shouldHave(text("Cart"));
        //$$("#cart tr[data-product-id").shouldHaveSize(1);

        $(".pr-tiny_title").shouldHave(text(productName));

    }

    private SelenideElement findProductById(String productId) {

        return $(by("data-product-id", productId));
    }

}
