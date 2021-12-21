package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import api.pojos.CardPojo;
import framework.DateProperties;
import framework.SetDate;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ECreateDueDateNextDayTest {

    //Поставить срок выполнения на следующий день
    @Test
    public void createDateNextDay() throws Exception {
        String idList = DateProperties.getFile("idListBacklog");

        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        Response resIdCard = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Карточка в которой меняется дата")
                .queryParam("idList", idList)
                .queryParam("due", SetDate.date())
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.card)
                .then().log().all()
                .assertThat().body("name", is("Карточка в которой меняется дата"))
                .extract().response();

        CardPojo response = resIdCard.getBody().as(CardPojo.class);
        String idCard = response.getId();

        DateProperties.changeFile("idCard", idCard);
    }
}
