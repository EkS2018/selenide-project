package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import config.TestConfig;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CreativePage;


public class TestCreative extends TestConfig {
    CreativePage crtPage = Selenide.page(CreativePage.class);
    TestConfig setup = new TestConfig();


    @ExtendWith({TextReportExtension.class})

    @Test
    @Description("Тест 1")
    public void checkSiteCreative() {
        crtPage.searchCreativeSite();
        crtPage.clickCreativeSite();
        crtPage.checkCreativeSite();
        crtPage.checkCreativeContacts();
        crtPage.checkCreativePhone();
        crtPage.checkCreativeEmail();
    }
}