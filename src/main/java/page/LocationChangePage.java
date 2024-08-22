package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static utils.Selectors.*;

public class LocationChangePage {

    private SelenideElement enteringAddress = $(ENTERING_ADDRESS);
    private SelenideElement addressElement = $(ADDRESS_ELEMENT);
    private SelenideElement pickupPoint = $(PICKUP_POINT);
    private SelenideElement addressDetails = $(ADDRESS_DETAILS);
    private SelenideElement addressSelectionButton = $(ADDRESS_SELECTION_BUTTON);
    private SelenideElement changeLocation = $(CHANGE_LOCATION);

    public LocationChangePage enterCity(String city) {
        enteringAddress.setValue(city).pressEnter();
        addressElement.shouldBe(visible).click();
        pickupPoint.shouldBe(visible);
        return this;
    }

    public LocationChangePage confirmAddressSelection() {
        addressSelectionButton.click();
        pickupPoint.shouldNotBe(visible);
        return this;
    }

    public LocationChangePage verifyChangedLocation(String selectedAddress) {
        changeLocation.shouldHave(text(selectedAddress));
        return this;
    }

    public String getSelectedAddress() {
        addressDetails.shouldBe(visible, Duration.ofSeconds(30));
        return addressDetails.getText();
    }
}
