package SerialiseDesrialsePractice;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

import static io.restassured.RestAssured.given;

public class GetListAPITest {

    @Test
    public void getListResourceAPITest(){
        RestAssured.baseURI="https://reqres.in/api/unknown";

      DataPojo dataPojo =  given().contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .response().as(DataPojo.class);

        System.out.println(dataPojo.getSupport().getUrl());
        System.out.println(dataPojo.getData().get(0).getId());
    }
}
