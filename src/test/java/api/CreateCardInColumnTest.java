package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import api.pojos.CardPojo;
import framework.DateProperties;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CreateCardInColumnTest {
    @Test
    public void createCard() throws Exception {
        String idList = DateProperties.getFile("idListBacklog");

        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        Response resIdCard = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Карточка для изучения API")
                .queryParam("idList", idList)
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.card)
                .then().log().all()
                .assertThat().body("name", is("Карточка для изучения API"))
                .extract().response();

        CardPojo response = resIdCard.getBody().as(CardPojo.class);
        String idCard = response.getId();

        DateProperties.changeFile("idCard", idCard);
    }
}
