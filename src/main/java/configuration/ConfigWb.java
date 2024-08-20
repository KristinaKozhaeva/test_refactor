package configuration;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class ConfigWb {
    public static void getConfig() {
        Configuration.browserSize = "1920x1080";
        open("https://www.wildberries.ru/");
        Configuration.timeout = 50000;
    }
}
