package ui;

import org.junit.jupiter.api.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class ACheckCardInRowDoneTest {

    //Удостовериться, что карточка находится в колонке Done
    @Test
    public void checkCardDone() {
        LoginSteps.login();
        BaseSteps.openBoard("KanbanTool");
        BaseSteps.isDisplayedCard("Карточка для изучения API");
        BaseSteps.cardIsLocatedIn("Карточка для изучения API", "Done");
        LoginSteps.driver.close();
    }
}
