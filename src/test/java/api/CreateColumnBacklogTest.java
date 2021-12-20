package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import api.pojos.ColumnPojo;
import framework.DateProperties;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CreateColumnBacklogTest {

    @Test
    public void createColumn() throws Exception {
        String idBoard = DateProperties.getFile("idBoard");

        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        Response resIdColumn = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Backlog")
                .queryParam("idBoard", idBoard)
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.list)
                .then().log().all()
                .assertThat().body("name", is("Backlog"))
                .extract().response();

        ColumnPojo response = resIdColumn.getBody().as(ColumnPojo.class);
        String idBacklog = response.getId();

        DateProperties.changeFile("idListBacklog", idBacklog);
    }
}

