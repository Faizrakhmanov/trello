package ui;

import org.junit.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class FChangeVisibilityBoardTest {

    //Изменение видимости доски
    @Test
    public void changeVisibility() {
        LoginSteps.login();
        BaseSteps.openBoard("KanbanTool");
        BaseSteps.changeVisibility();
        LoginSteps.driver.close();
    }
}
