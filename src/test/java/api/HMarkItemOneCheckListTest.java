package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import framework.DateProperties;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class HMarkItemOneCheckListTest {

    //Отметить пункт в карточке "Понять протокол HTTP"
    @Test
    public void markItem() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        String idCard = DateProperties.getFile("idCard");
        String idCheckItemOne = DateProperties.getFile("idCheckItemOne");

        given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("state", "complete")
                .when().put(EndPoints.card + idCard + EndPoints.checkItem + idCheckItemOne)
                .then().log().all()
                .assertThat().body("name", is("Понять протокол HTTP")).and().body("state", is("complete"));
    }
}
