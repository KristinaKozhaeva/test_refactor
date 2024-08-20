import org.junit.jupiter.api.*;
import page.*;
import configuration.ConfigWb;
import utils.TestData;

import static com.codeborne.selenide.Selenide.*;

public class WildberriesTests {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private LocationChangePage changeLocationPage;
    private LaptopPage laptopsPage;
    private FiltersPage filtersPage;

    @BeforeEach
    public void setUp() {
        ConfigWb.getConfig();

        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
        changeLocationPage = new LocationChangePage();
        laptopsPage = new LaptopPage();
        filtersPage = new FiltersPage();
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
    @DisplayName("Работа с поисковой строкой")
    public void searchBarTest() {
        homePage.enterSearchText(TestData.DATA_TO_ENTER);
        searchResultsPage.verifySearchResult(TestData.DATA_TO_ENTER);
        searchResultsPage.verifyFirstFilterText(TestData.FIRST_FILTER_TEXT);
        searchResultsPage.verifySecondFilterText(TestData.SECOND_FILTER_TEXT);
        searchResultsPage.verifyProductBrand(TestData.BRAND);
        searchResultsPage.clearSearchInput();
    }

    @Test
    @DisplayName("Смена города")
    public void changeCityTest() {
        homePage.clickChangeLocation();
        changeLocationPage.enterCity("Санкт-Петербург");
        String selectedAddress = changeLocationPage.getSelectedAddress();
        changeLocationPage.confirmAddressSelection();
        changeLocationPage.verifyChangedLocation(selectedAddress);
    }

    @Test
    @DisplayName("Работа с фильтрами")
    public void usageFiltersTest() {
        laptopsPage.navigateToLaptopsCategory();
        laptopsPage.verifyLaptopsPage();
        filtersPage.clickAllFiltersDropdown();
        filtersPage.setPriceRange(TestData.PRICE_MIN, TestData.PRICE_MAX);
        filtersPage.applyFilters(TestData.BRAND, TestData.SCREEN_DIAGONAL, TestData.DELIVERY_TIME);
        filtersPage.verifyFilteredResults();
    }
}