package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import api.pojos.BoardPojo;
import framework.DateProperties;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CreateBoardKanbanToolTest {

    @Test
    public void boardTest() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());

        Response resIdBoard = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "KanbanTool")
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.board)
                .then().log().all()
                .assertThat().body("name", is("KanbanTool"))
                .extract().response();
        BoardPojo response = resIdBoard.getBody().as(BoardPojo.class);
        String idBoard = response.getId();

        DateProperties.changeFile("idBoard", idBoard);
    }

    @Test
    public void createCheckList() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        String idCard = DateProperties.getFile("idCard");

        String id = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Прогресс")
                .when().post(EndPoints.card + idCard + EndPoints.checklist)
                .then().log().all()
                .extract()
                .jsonPath()
                .get("id");

        String idCheckItemOne = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Понять протокол HTTP")
                .when().post(EndPoints.checklist + id + EndPoints.checkItems)
                .then().log().all()
                .extract()
                .jsonPath()
                .get("id");

        String idCheckItemTwo = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Выучить методы запросов")
                .when().post(EndPoints.checklist + id + EndPoints.checkItems)
                .then().log().all()
                .extract()
                .jsonPath()
                .get("id");

        DateProperties.changeFile("idCheckItemOne", idCheckItemOne);
        DateProperties.changeFile("idCheckItemTwo", idCheckItemTwo);
    }
    }
