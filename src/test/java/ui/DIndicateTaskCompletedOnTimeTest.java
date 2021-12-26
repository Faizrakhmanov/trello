package ui;

import org.junit.jupiter.api.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class DIndicateTaskCompletedOnTimeTest {

    @Test
    public void completeOnTime() {
        LoginSteps.login();
        BaseSteps.openBoard("KanbanTool");
        BaseSteps.isDisplayedCard("Карточка для изучения API");
        BaseSteps.openCard("Карточка для изучения API");
        BaseSteps.checkTaskCompleted();
        LoginSteps.driver.close();
    }
}
