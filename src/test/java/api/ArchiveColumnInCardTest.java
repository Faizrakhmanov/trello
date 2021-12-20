package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import framework.DateProperties;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ArchiveColumnInCardTest {
    @Test
    public void archiveColumn() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());
        String idListBacklog = DateProperties.getFile("idListBacklog");

        given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("value", "true")
                .when().put(EndPoints.list + idListBacklog + EndPoints.closed)
                .then().log().all()
                .assertThat().body("closed", is(true)).and().body("name", is("Backlog"));
    }
}
