package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoardPage {
    public static WebDriver driver;

    public BoardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        BoardPage.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@class,'show-menu')]//span[contains(@class,'btn-text')]")
    private WebElement menu;

    @FindBy(xpath = "//a[contains(text(), 'Сменить фон')]")
    private WebElement changeCover;

    @FindBy(xpath = "//div[contains(@class,'board-backgrounds')]/*[text()='Цвета']")
    private WebElement colors;

    @FindBy(xpath = "//div[contains(@style,'rgb(81, 152, 57)')]")
    private WebElement green;

    public void openMenu() {
        menu.click();
    }

    public void changeCover() {
        changeCover.click();
    }

    public void selectColors() {
        colors.click();
    }

    public void selectColorGreen() {
        green.click();
    }
}
