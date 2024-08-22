package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Selectors.*;
import static utils.TestData.*;

public class FiltersPage {

    private SelenideElement allFiltersDropdown = $(ALL_FILTERS_DROPDOWN);

    public FiltersPage clickAllFiltersDropdown() {
        allFiltersDropdown.click();
        return this;
    }

    public FiltersPage setPriceRange(String minPrice, String maxPrice) {
        $(byName("startN")).setValue(minPrice);
        $(byName("endN")).setValue(maxPrice);
        return this;
    }

    public FiltersPage applyFilters(String brand, String screenDiagonal, String deliveryTime) {
        $(byText(deliveryTime)).click();
        $(byText(brand)).click();
        $(byText(screenDiagonal)).click();
        $(byText(SHOW_BUTTON)).click();
        return this;
    }

    public FiltersPage verifyFilteredResults() {
        SelenideElement goodsCount = $(By.cssSelector(".goods-count > span"));
        goodsCount.shouldBe(visible);
        int displayedGoodsCount = Integer.parseInt(goodsCount.text().replaceAll("\\D", ""));
        int actualGoodsCount = $$(By.cssSelector(".product-card-list .product-card")).size();
        assert displayedGoodsCount == actualGoodsCount;
        $(byText(PRICE_RANGE)).shouldBe(Condition.visible);
        $(byText(DELIVERY_TIME)).shouldBe(Condition.visible);
        $(byText(BRAND)).shouldBe(Condition.visible);
        $(byText(SCREEN_DIAGONAL)).shouldBe(Condition.visible);
        $(byText(RESET_ALL_BUTTON)).shouldBe(Condition.visible);
        return this;
    }
}
