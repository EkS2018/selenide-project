package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class CreativePage {
    private final String InputSearch = "//input[@aria-label='Найти']";
    private final String ButtonSearch = "gNO89b";
    private final String LinkCreative = "//cite[text()='https://crtweb.ru']";
    private final String NumberCreative = "+7(499)113-68-89";
    private final String UrlCreativeContacts = "https://crtweb.ru/contacts";
    private final String EmailCreative = "mail@crtweb.ru";
    private final String UrlCreative = "https://crtweb.ru/";
    private final String CheckboxMenu = "//nav[@class='nav d-flex pl-20']/input[@type='checkbox']";
    private final String LinkContacts = "//li/a[text()='контакты']";
    private final String LinkNumberPhone = "(//div[@class='tn-atom__sbs-anim-wrapper']/a)[3]";
    private final String LinkEmail = "(//div[@class='tn-atom__sbs-anim-wrapper']/a)[4]";
    private final String ValueSearch = "creative тюмень";

    @Step("Поиск сайта в хроме")
    public void searchCreativeSite() {
        Selenide.open("https://www.google.ru/");
        sendHumanKeys($(byXpath(InputSearch)).should(exist), ValueSearch);
        $(byClassName(ButtonSearch)).shouldBe(visible).click();
    }

    @Step("Клик на ссылку сайта Креатива")
    public void clickCreativeSite() {
        $(byXpath(LinkCreative)).should(exist).click();
    }

    @Step("Переход на сайт Креатива и проверка ула")
    public void checkCreativeSite() {
        switchTo().window(1);
        String urlOpened = url();
        assertEquals(urlOpened + " не совпадает с " + UrlCreative, urlOpened, UrlCreative);
    }



    @Step("Переход на страницу контактов и проверка урла")
    public void checkCreativeContacts() {
        $(byXpath(CheckboxMenu)).shouldBe(visible).click();
        $(byXpath(LinkContacts)).shouldBe(visible).click();
        String urlContacts = url();
        assertEquals(urlContacts + " не совпадает с " + UrlCreativeContacts, urlContacts, UrlCreativeContacts);
    }

    @Step("Проверка телефона")
    public void checkCreativePhone() {
        String numberPhone = $(byXpath(LinkNumberPhone)).should(exist).innerHtml()
                .replaceAll("\\s", "")
                .trim();
        assertEquals(numberPhone + " не совпадает с " + NumberCreative, numberPhone, NumberCreative);
    }

    @Step("Проверка email")
    public void checkCreativeEmail() {
        String email = $(byXpath(LinkEmail)).should(exist).innerHtml()
                .trim();
        assertEquals(email + " не совпадает с " + EmailCreative, email, EmailCreative);
    }


    protected void sendHumanKeys(WebElement element, String text) {
        text.chars().asLongStream().forEachOrdered((charCode) -> {
            sleep(100);
            element.sendKeys(String.valueOf((char) charCode));
        });
    }
}
