package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Selectors.*;

public class SearchResultsPage {

    private SelenideElement searchResult = $(SEARCH_RESULT);
    private SelenideElement firstFilter = $$(FIRST_FILTER).first();
    private SelenideElement secondFilter = $(SECOND_FILTER);
    private SelenideElement productCard = $(byClassName(PRODUCT_CARD));
    private SelenideElement productBrand = $(".product-card__link").closest("article").find(PRODUCT_BRAND);
    private SelenideElement clearSearch = $(CLEAR_SEARCH);
    private SelenideElement searchInput = $(SEARCH_INPUT);

    public void verifySearchResult(String expectedText) {
        searchResult.shouldHave(text(expectedText));
    }

    public void verifyFirstFilterText(String expectedText) {
        firstFilter.shouldHave(text(expectedText));
    }

    public void verifySecondFilterText(String expectedText) {
        secondFilter.shouldHave(text(expectedText));
    }

    public void verifyProductBrand(String expectedBrand) {
        productCard.shouldBe(visible);
        productBrand.shouldHave(text(expectedBrand));
    }

    public void clearSearchInput() {
        clearSearch.click();
        searchInput.shouldBe(empty);
    }
}