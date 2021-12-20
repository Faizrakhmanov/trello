package ui.steps;

import helpers.BaseData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import pages.LoginPage;
import pages.MainPage;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class LoginSteps {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static ChromeDriver driver;


    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    public static void login() {
        String link = "https://trello.com/login";
        driver.get(link);
        loginPage.inputLogin(BaseData.LOGIN.value, BaseData.PASSWORD.value);
        BaseSteps.waitLoad();
        mainPage.getMainPage().isDisplayed();
    }

}
