package ui;

import org.junit.Test;
import ui.steps.BaseSteps;
import ui.steps.LoginSteps;

public class BMakeAllCheckBoxItemsMetTest {

    //Удостовериться, все пункты чек-боксов выполнены
    @Test
    public void allCheckBoxItemsMet() {
        LoginSteps.login();
        BaseSteps.openBoard("KanbanTool");
        BaseSteps.isDisplayedCard("Карточка для изучения API");
        BaseSteps.openCard("Карточка для изучения API");
        BaseSteps.checkedItems("Понять протокол HTTP");
        BaseSteps.checkedItems("Выучить методы запросов");
        BaseSteps.closeCard();
        LoginSteps.driver.close();
    }
}
