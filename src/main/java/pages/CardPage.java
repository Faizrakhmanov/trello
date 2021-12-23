package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardPage {
    public static WebDriver driver;

    public CardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        CardPage.driver = driver;
    }

    @FindBy(xpath = "//a[@title='Обложка']")
    private WebElement cover;

    @FindBy(xpath = "//button[contains(@class,'1hFyzxe1')]")
    private WebElement colorGreen;

    public void openCover() {
        String cov = cover.getAttribute("class");
        if (cov.equals("button-link js-card-cover-chooser hide"))
            try {
                System.out.println("В карточке уже выбрана обложка");
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        cover.click();
        }

    public void selectColor() {
        colorGreen.click();
    }
}
