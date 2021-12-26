package ui;

import org.junit.jupiter.api.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class EChangeBoardBackgroundGreenTest {

    @Test
    public void changeBackground() {
        LoginSteps.login();
        BaseSteps.openBoard("KanbanTool");
        BaseSteps.selectBackground();
        LoginSteps.driver.close();
    }
}
