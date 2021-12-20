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

public class CreateDescriptionInCardTest {
    @Test
    public void createDescription() throws Exception {
        String idList = DateProperties.getFile("idListBacklog");

        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        Response resIdCard = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Карточка в которой отмечается прогресс")
                .queryParam("desc", "Тут будет отмечаться прогресс обучения")
                .queryParam("idList", idList)
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.card)
                .then().log().all()
                .assertThat().body("name", is("Карточка в которой отмечается прогресс")).and().body("desc", is("Тут будет отмечаться прогресс обучения"))
                .extract().response();

        CardPojo response = resIdCard.getBody().as(CardPojo.class);
        String idCard = response.getId();

        DateProperties.changeFile("idCard", idCard);
    }
}
