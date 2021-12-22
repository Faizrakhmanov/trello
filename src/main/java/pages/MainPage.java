package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public static WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        MainPage.driver = driver;
    }

    @FindBy(xpath = "//div[@class='home-sticky-container']")
    private WebElement mainPage;

    @FindBy(xpath = "//span[text()='Меню']")
    private WebElement menu;

    @FindBy(xpath = "//a[contains(text(), 'Сменить фон')]")
    private WebElement changeCover;

    public WebElement getMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='home-sticky-container']")));
        return mainPage;
    }

    public void openMenu() {
        menu.click();
        changeCover.click();
    }

}