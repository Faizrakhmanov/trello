package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import framework.DateProperties;
import org.junit.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;

public class MoveCardInColumnTest {
    @Test
    public void updateCard() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        String idCard = DateProperties.getFile("idCard");
        String idListDone = DateProperties.getFile("idListDone");

        given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("idList", idListDone)
                .when().put(EndPoints.card + idCard)
                .then().log().all();
    }
}
