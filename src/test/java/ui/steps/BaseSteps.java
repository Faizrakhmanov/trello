package ui.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BoardPage;
import pages.CardPage;
import pages.MainPage;

public class BaseSteps {
    public static WebDriver driver;

    public static void isDisplayedCard(String name) {
        MainPage.driver.findElement(By.xpath("//span[text()='" + name + "']/ancestor::a[contains(@class, 'list-card')]")).isDisplayed();
    }

    public static void waitLoad() {
        (new WebDriverWait(MainPage.driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='chrome-container']")));
    }

    public static void openBoard(String name) {
        WebElement element = MainPage.driver.findElement(By.xpath("//div[@title='" + name + "']/parent::div"));
        element.isDisplayed();
        element.click();
        waitLoad();
    }

    public static void openCard(String name) {
        WebDriverWait wait = new WebDriverWait(MainPage.driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + name + "']/ancestor::div[contains(@class,'card-details')]")));
        element.click();
    }

    public static void cardIsLocatedIn(String nameCard, String nameColumn) {
        try {
            waitLoad();
            boolean element = MainPage.driver.findElement(By.xpath("//h2[text()='" + nameColumn + "']" +
                    "/ancestor::div[contains(@class,'content')]//span[text()='" + nameCard + "']"))
                    .isDisplayed();
            if (element) {
                System.out.println("Карточка " + nameCard + " находится в колонке " + nameColumn + ".");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Карточка " + nameCard + " не в требуемой колонке!");
            System.exit(1);
            driver.close();
        }
    }

    public static void selectBackground() {
        BoardPage boardPage = new BoardPage(MainPage.driver);
        boardPage.changeCover();
        boardPage.selectColors();
        boardPage.selectColorGreen();
    }

    public static void selectCover() {
        CardPage cardPage = new CardPage(MainPage.driver);
        cardPage.openCover();
        cardPage.selectColor();
    }
}
