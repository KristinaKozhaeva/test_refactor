package page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static utils.Selectors.*;

public class HomePage {

    private SelenideElement searchInput = $(SEARCH_INPUT);
    private SelenideElement changeLocation = $(CHANGE_LOCATION);

    public void enterSearchText(String text) {
        searchInput.click();
        searchInput.setValue(text).pressEnter();
    }

    public void clickChangeLocation() {
        changeLocation.click();
    }
}