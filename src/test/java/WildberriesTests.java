import org.junit.jupiter.api.*;
import page.*;
import configuration.ConfigWb;
import utils.TestData;

import static com.codeborne.selenide.Selenide.*;

public class WildberriesTests {

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        ConfigWb.getConfig();
        homePage = new HomePage();
    }

    @BeforeEach
    public void cleanCookies() {
        clearBrowserCookies();
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Смена города")
    public void changeCityTest() {
        String selectedAddress = "Санкт-Петербург";
        homePage
                .clickChangeLocation()
                .selectAndConfirmAddressSelection(selectedAddress)
                .verifyChangedLocation(selectedAddress);
    }

    @Test
    @DisplayName("Работа с поисковой строкой")
    public void searchBarTest() {
        homePage
                .enterSearchText(TestData.DATA_TO_ENTER)
                .verifySearchResult(TestData.DATA_TO_ENTER)
                .verifyFirstFilterText(TestData.FIRST_FILTER_TEXT)
                .verifySecondFilterText(TestData.SECOND_FILTER_TEXT)
                .verifyProductBrand(TestData.BRAND)
                .clearSearchInput();
    }

    @Test
    @DisplayName("Работа с фильтрами")
    public void usageFiltersTest() {
        LaptopPage laptopPage = new LaptopPage();
        laptopPage.navigateToLaptopsCategory()
                .verifyLaptopsPageAndGetFilter()
                .clickAllFiltersDropdown()
                .setPriceRange(TestData.PRICE_MIN, TestData.PRICE_MAX)
                .applyFilters(TestData.BRAND, TestData.SCREEN_DIAGONAL, TestData.DELIVERY_TIME)
                .verifyFilteredResults();
    }
}