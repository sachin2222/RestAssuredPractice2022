package reqresAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ReqresPostAPITest {
    Response response;

    @Test(priority = 1)
    public void postAPITest() {
        ReqresPostPojo pj = PostPayload.setpojoDetails();
        RestAssured.baseURI = "https://reqres.in/";

        response = (Response) given()
                .contentType(ContentType.JSON)
                .when()
                .body(pj)
                .post("/api/users").getBody();

        System.out.println(response.asString());
        System.out.println(response.getStatusLine());
   

    }

    @Test(priority = 2)
    public void validations() {
        response.then().assertThat().statusCode(201)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body("name", equalTo("sachin"))
                .and()
                .time(lessThan(1500L)); // Response time Validation for less than 1500 mili seconds
    }

    @Test(priority = 3)
    public void getID() {
        ReqresPostPojo deserialise = response.as(ReqresPostPojo.class);
        System.out.println(deserialise.getId());
    }
}
