package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class MainPageTest extends TestBase {
MainPage mainPage = new MainPage();
    @Test
    @Tag("mainpage")
    @Tag("smoke")
    @Owner("m.khayrullin")
    @DisplayName("Открытие главной страницы")
    void mainPageOpenTest() {
        step("Oткрыть главную страницу",() -> {
            mainPage.openPage();
        });
        step("Проверить, что загрузилась главная страница",() -> {
            mainPage.mainPageCheckText.shouldHave(Condition.text("Открытые магазины в вашем городе"));
        });
    }

    @CsvSource(value = {
            "Смартфоны и гаджеты      |   [href='https://www.mvideo.ru/telefony']                        |      Телефоны",
            "Ноутбуки и компьютеры    |   [href='https://www.mvideo.ru/noutbuki-planshety-i-kompyutery'] |      Ноутбуки, планшеты и компьютеры",
    },
    delimiter = '|')
    @Tag("regression")
    @Tag("mainpage")
    @Owner("m.khayrullin")
    @DisplayName("Переход в разделы из каталога на главной")
    @ParameterizedTest(name = "Переход в раздел {0}")
    void moveToChaptersFromCatalog(String menu, String selector, String name) {
        step("Oткрыть главную страницу",() -> {
            mainPage.openPage();
        });
        step("Кликнуть на каталог",() -> {
            $(byText("Каталог")).click();
        });
        step("Кликнуть по категории",() -> {
            $(selector).click();
        });
        step("Проверить переход в нужную категорию",() -> {
            mainPage.categoryList.shouldHave(text(name));
        });
    }

}