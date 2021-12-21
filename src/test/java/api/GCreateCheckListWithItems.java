package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import api.pojos.CheckItemPojo;
import api.pojos.CheckListPojo;
import framework.DateProperties;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GCreateCheckListWithItems {

    //Создать чек-лист с пунктами: Понять протокол HTTP, Выучить методы запросов
    @Test
    public void createCheckList() throws Exception {
        String idCard = DateProperties.getFile("idCard");
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());

        Response resIdCheckList = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Чек-лист")
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.card + idCard + EndPoints.checklist)
                .then().log().all()
                .assertThat().body("name", is("Чек-лист"))
                .extract().response();

        CheckListPojo response = resIdCheckList.getBody().as(CheckListPojo.class);
        String idCheckList = response.getId();

        Response resIdCheckItemOne = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Понять протокол HTTP")
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.checklist + idCheckList + EndPoints.checkItems)
                .then().log().all()
                .assertThat().body("name", is("Понять протокол HTTP"))
                .extract().response();

        CheckItemPojo respItemOne = resIdCheckItemOne.getBody().as(CheckItemPojo.class);
        String idCheckItemOne = respItemOne.getId();

        Response resIdCheckItemTwo = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Выучить методы запросов")
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.checklist + idCheckList + EndPoints.checkItems)
                .then().log().all()
                .assertThat().body("name", is("Выучить методы запросов"))
                .extract().response();

        CheckItemPojo respItemTwo = resIdCheckItemTwo.getBody().as(CheckItemPojo.class);
        String idCheckItemTwo = respItemTwo.getId();

        DateProperties.changeFile("idCheckItemOne", idCheckItemOne);
        DateProperties.changeFile("idCheckItemTwo", idCheckItemTwo);
    }
}

