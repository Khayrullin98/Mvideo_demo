package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.Allure.step;


public class SearchTest extends TestBase {

    MainPage mainPage = new MainPage();
    private static final String SEARCHTEXT = "Ноутбук HUAWEI MateBook D 16 i5 12450H/16/512Gb DOS Space Gray";
    @Test
    @Tag("search")
    @Tag("smoke")
    @Owner("m.khayrullin")
    @DisplayName("Поиск на главной странице")
    void mainPageSearchTest() {
        step("Oткрыть главную страницу", () -> {
            mainPage.openPage();
            mainPage.mainPageCheckText.shouldHave(Condition.text("Открытые магазины в вашем городе"));
        });
        step("Ввести в строку поиска "+ "'" + SEARCHTEXT + "'", () -> {
            mainPage.searchButton.click();
            mainPage.searchButton.sendKeys(SEARCHTEXT);
            mainPage.searchButton.pressEnter();
        });
        step("Проверить наличие в результатах поиска искомый запрос " + "'"+ SEARCHTEXT + "'", () -> {
            mainPage.searchResult.shouldHave(Condition.text(SEARCHTEXT));
        });
    }
}