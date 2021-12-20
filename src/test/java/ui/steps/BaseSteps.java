package ui.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.time.Duration;

public class BaseSteps {
    public static WebDriver driver;

    public static void isDisplayedCard(String name) {
        MainPage.driver
                .findElement(By.xpath("//span[text()='\" + name + \"']/ancestor::a[contains(@class, 'list-card')]"))
                .isDisplayed();
    }

    public static void waitLoad() {
        (new WebDriverWait(MainPage.driver, Duration.ofSeconds(60)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='chrome-container']")));
    }
}
