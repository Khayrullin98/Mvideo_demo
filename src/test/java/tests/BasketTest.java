package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BasketPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static io.qameta.allure.Allure.step;

public class BasketTest extends TestBase {
    BasketPage basketPage = new BasketPage();

    @Test
    @Tag("basket")
    @Tag("smoke")
    @Owner("m.khayrullin")
    @DisplayName("Добавление товара в корзину")
    void addItemToCartTest() {
        step("Oткрыть страницу товара",() -> {
            basketPage.openItemPage();
        });
        step("Добавить товар  корзину",() -> {
            $(byText("Добавить в корзину")).click();
        });
        step("Проверить добавление товара",() -> {
            $(basketPage.addToBasket).hover();
            $(basketPage.basketIcon).shouldHave(Condition.text(basketPage.item));
        });
    }
    @Test
    @Tag("basket")
    @Tag("regression")
    @Disabled("Тест для более красивого отчета в Allure, запуск не требуется")
    @Owner("m.khayrullin")
    @DisplayName("Открытие страницы товара")
    void openItemTPage() {
        step("Oткрыть страницу товара",() -> {
            basketPage.openItemPage();
        });
    }
}
