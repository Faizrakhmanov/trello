package ui;

import org.junit.jupiter.api.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class CPutCoverGreenColorTest {

    //Поставить обложку с зеленым цветом
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
