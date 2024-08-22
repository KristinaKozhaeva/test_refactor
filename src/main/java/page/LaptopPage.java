package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static utils.Selectors.*;
import static utils.TestData.*;

public class LaptopPage {

    private SelenideElement category = $(CATEGORY);
    private SelenideElement electronicsCategory = $(ELECTRONICS_CATEGORY);
    private SelenideElement laptopsAndComputersCategory = Selenide.$(By.cssSelector(CATEGORY_LAPTOPS_COMPUTERS));
    private SelenideElement laptopsCategory = Selenide.$(By.cssSelector(CATEGORY_LAPTOPS));
    private SelenideElement header = $(byCssSelector("h1"));

    public LaptopPage navigateToLaptopsCategory() {
        category.hover().click();
        electronicsCategory.shouldBe(visible).click();
        laptopsAndComputersCategory.shouldBe(visible, enabled).click();
        laptopsCategory.shouldBe(visible, enabled).click();
        return this;
    }

    public LaptopPage verifyLaptopsPage() {
        header.shouldHave(Condition.text(LAPTOPS));
        return this;
    }
}
