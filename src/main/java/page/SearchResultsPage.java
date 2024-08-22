package page;

import com.codeborne.selenide.Condition;
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

    public SearchResultsPage verifySearchResult(String expectedText) {
        searchResult.shouldHave(Condition.text(expectedText));
        return this;
    }

    public SearchResultsPage verifyFirstFilterText(String expectedText) {
        firstFilter.shouldHave(Condition.text(expectedText));
        return this;
    }

    public SearchResultsPage verifySecondFilterText(String expectedText) {
        secondFilter.shouldHave(Condition.text(expectedText));
        return this;
    }

    public SearchResultsPage verifyProductBrand(String expectedBrand) {
        productCard.shouldBe(Condition.visible);
        productBrand.shouldHave(Condition.text(expectedBrand));
        return this;
    }

    public SearchResultsPage clearSearchInput() {
        clearSearch.click();
        searchInput.shouldBe(empty);
        return this;
    }
}