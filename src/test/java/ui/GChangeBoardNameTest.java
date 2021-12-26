package ui;

import org.junit.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class GChangeBoardNameTest {

    //Сменить имя доски на "Только для образования"
    @Test
    public void changeBoardName() {
        LoginSteps.login();
        BaseSteps.openBoard("KanbanTool");
        BaseSteps.changeNameBoard("Только для образования");
        LoginSteps.driver.close();
    }
}
