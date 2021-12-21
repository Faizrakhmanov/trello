package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import framework.DateProperties;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class LMarkItemTwoCheckListTest {

    //Отметить пункт в карточке "Выучить методы запросов"
    @Test
    public void markItem() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        String idCard = DateProperties.getFile("idCard");
        String idCheckItemTwo = DateProperties.getFile("idCheckItemTwo");

        given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("state", "complete")
                .when().put(EndPoints.card + idCard + EndPoints.checkItem + idCheckItemTwo)
                .then().log().all()
                .assertThat().body("name", is("Выучить методы запросов")).and().body("state", is("complete"));
    }
}
