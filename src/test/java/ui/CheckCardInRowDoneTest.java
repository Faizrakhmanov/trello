package ui;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import ui.steps.BaseSteps;
import ui.steps.BaseTest;
import ui.steps.LoginSteps;

public class CheckCardInRowDoneTest {

    @Test
    public void checkCardDone() {
        LoginSteps.login();
        BaseSteps.open("KanbanTool");
        BaseSteps.isDisplayedCard("Карточка для изучения API");
        BaseSteps.cardIsLocatedIn("Карточка для изучения API", "Done");
        LoginSteps.driver.close();
    }
}
