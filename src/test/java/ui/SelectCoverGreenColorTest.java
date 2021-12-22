package ui;

import org.junit.jupiter.api.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class SelectCoverGreenColorTest {

    @Test
    public void selectCover() {
        LoginSteps.login();
        BaseSteps.open("KanbanTool");
        BaseSteps.menuInBoard();
    }
}
