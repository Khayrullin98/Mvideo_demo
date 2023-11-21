package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BasketPage  {
    public String item = "Ноутбук HUAWEI MateBook D 16 i5 12450H/16/512Gb DOS Space Gray";
    public SelenideElement
            addToBasket = $("[href='https://www.mvideo.ru/cart']"),
            basketIcon = $(".tooltip__item");



    public BasketPage openItemPage() {
        open("https://www.mvideo.ru/products/noutbuk-huawei-matebook-d-16-i5-12450h-16-512gb-dos-space-gray-30067548");

        return this;
    }
    public BasketPage removeBanners() {
        executeJavaScript("$('notification__text').remove()");

        return this;
    }

}
