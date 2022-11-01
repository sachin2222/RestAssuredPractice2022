package Practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddPlaceAPI {
    String place_id;

    @BeforeSuite
    public void setBaseURI() {
        RestAssured.baseURI = "https://rahulshettyacademy.com/";
    }

    @Test(priority = 1)
    public void addPlaceAPITest() {

        String response = given()
                .when().body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"New Delhi\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n").post("/maps/api/place/add/json?key =qaclick123").getBody().asString();

        JsonPath js = new JsonPath(response);
        place_id = js.getString("place_id");
        System.out.println(place_id);

    }

    @Test(priority = 2)
    public void getPlace() {
        String data = given().queryParam("key", "qaclick123")
                .queryParam("place_id", place_id)
                .get("/maps/api/place/get/json").getBody().asString();

        System.out.println(data);


    }

}
