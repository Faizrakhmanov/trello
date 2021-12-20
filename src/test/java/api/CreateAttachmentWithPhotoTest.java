package api;

import api.Specification.Specification;
import api.helpers.EndPoints;
import framework.DateProperties;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;

import static api.helpers.EndPoints.baseUrl;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CreateAttachmentWithPhotoTest {
    @Test
    public void createAttachment() throws Exception {
        Specification.installSpecification(Specification.requestSpec(baseUrl), Specification.responseSpecOK200());

        String idCard = DateProperties.getFile("idCard");
        given().log().all()
                .queryParam("key", EndPoints.api)
                .queryParam("token", EndPoints.token)
                .queryParam("name", "Logo Trello")
                .queryParam("url", EndPoints.fileUrl)
                .expect().defaultParser(Parser.JSON)
                .when().post(EndPoints.card + idCard + EndPoints.attach)
                .then().log().all()
                .assertThat().body("isUpload", is(true)).and().body("name", is("Logo Trello"))
                .extract().response();
    }
}
