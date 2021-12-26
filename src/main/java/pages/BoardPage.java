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

    @FindBy(xpath = "//h1[contains(@class,'board-header')]")
    private WebElement nameBoard;

    @FindBy(xpath = "//a[@id='permission-level']")
    private WebElement visibility;

    @FindBy(xpath = "//a[@name='public']/span[contains(@class,'icon')]")
    private WebElement visibilityPublic;

    @FindBy(xpath = "//button[contains(@class, 'make-public')]")
    private WebElement makePublic;

    @FindBy(xpath = "//input[contains(@class, 'board')]")
    private WebElement changeNameBoard;

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

    public void selectVisibility() {
        visibility.click();
    }

    public void selectPublic() {
        visibilityPublic.click();
    }

    public void makePublicBoard() {
        makePublic.click();
    }

    public WebElement nameBord() {
        return nameBoard;
    }

    public WebElement changeBoard() {
        return changeNameBoard;
    }
}
