package reqresAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ReqresGetAPITest {

    @Test
    public void testGetAPI() {
        RestAssured.baseURI = "https://reqres.in/api/";

        GetRequestPojo get = given().
                contentType(ContentType.JSON)
                .pathParam("id", "2")
                .when().get("users/{id}")
                .then().log().all()
                .extract().response().as(GetRequestPojo.class);

        System.out.println(get.getData().getId());
        System.out.println(get.getData().getEmail());
        System.out.println(get.getData().getAvatar());


    }
}
