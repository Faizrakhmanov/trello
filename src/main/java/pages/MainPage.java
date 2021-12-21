package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    @FindBy(xpath = "//div[@class='home-sticky-container']")
    private WebElement mainPage;

    public static WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        MainPage.driver = driver;
    }

    public WebElement getMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) mainPage));
        return mainPage;
    }
}
