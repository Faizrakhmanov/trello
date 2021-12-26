package ui;

import org.junit.jupiter.api.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class CPutCoverGreenColorTest {

    @Test
    public void changeCover() {
        LoginSteps.login();
        BaseSteps.openBoard("KanbanTool");
        BaseSteps.isDisplayedCard("Карточка для изучения API");
        BaseSteps.openCard("Карточка для изучения API");
        BaseSteps.selectCover();
        LoginSteps.driver.close();
    }
}
