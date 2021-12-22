package ui.steps;

import helpers.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static WebDriver driver;

    public static void login() {
        System.setProperty("webdriver.chrome.driver", TestConfig.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com/login");
        loginPage.inputLogin("testtrellouser553@mail.ru", "yUypIIyHy-41");
        BaseSteps.waitLoad();
        mainPage.getMainPage().isDisplayed();

    }
}
