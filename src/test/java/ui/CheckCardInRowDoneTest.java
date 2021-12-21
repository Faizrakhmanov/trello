package ui;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import ui.steps.BaseTest;

public class CheckCardInRowDoneTest extends BaseTest {

    private final static String baseUrl = "https://trello.com/login";

    @Test
    public void checkCardDone() {
        LoginPage loginPage = new LoginPage();
        loginPage.open(baseUrl);
        loginPage.login();
//        loginPage.inputLogin("testtrellouser553@mail.ru", "yUypIIyHy-41");
    }
}
