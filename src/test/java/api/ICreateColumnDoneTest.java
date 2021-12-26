package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import framework.DateProperties;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ICreateColumnDoneTest {

    //Создать колонку "Done"
    @Test
    public void createColumn() throws Exception {
        String idBoard = DateProperties.getFile("idBoard");

        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        String idDone = given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Done")
                .queryParam("idBoard", idBoard)
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.list)
                .then().log().all()
                .assertThat().body("name", is("Done"))
                .extract().jsonPath().get("id");

        DateProperties.changeFile("idListDone", idDone);
    }
}
