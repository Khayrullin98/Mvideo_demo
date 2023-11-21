package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public SelenideElement
            mainPageCheckText = $(".mvid-carousel-inner"),
            categoryList = $(".c-breadcrumbs__list"),
            searchButton = $(".input__field--indent-from-icon"),
            searchResult = $(".plp__card-grid");


    public MainPage openPage() {
        open("/");

        return this;
    }

}
