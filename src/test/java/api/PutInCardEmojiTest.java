package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import framework.DateProperties;
import org.junit.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;

public class PutInCardEmojiTest {
    @Test
    public void addEmoji() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        String idCard = DateProperties.getFile("idCard");

        given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("text", ":thumbsup: ")
                .when().post(EndPoints.card  + idCard + EndPoints.comment)
                .then().log().all();
    }
}
