package Practice;

import DataProviders.APIData;
import Payload.AddPlacePayload;
import Pojo.AddPlacePojo;
import Utility.Base;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddPlaceAPITest extends Base {

    RequestSpecification requestSpecification;
    Response response;
    AddPlacePojo pj;
    RequestSpecification GetPlaceRequest;

    @Test(priority = 0)
    public void getAddPlaceAPIRequestDetails() {
        requestSpecification = given().spec(get_Request_spec_Details_for_AddPlaceAPI());

    }

    @Test(priority = 1, dataProviderClass = APIData.class, dataProvider = "AddPlaceAPI")
    public void getAddPlacePojo(int accuracy, String address, String website, String language,
                                double latitude, double longitude, String name, String phone_number) {

        pj = AddPlacePayload.setPayloadAttributeValues(accuracy, address, website, language, latitude, longitude, name, phone_number);

    }

    @Test(priority = 2)
    public void PostAddPlaceAPIRequest() {
        response = (Response) requestSpecification.when().body(pj).post("/maps/api/place/add/json").getBody();
        System.out.println(response.asString());

    }

    @Test(priority = 3)
    public void validateStatusCode() {
        response.then().assertThat().statusCode(200);

    }

    @Test(priority = 4)
    public void getPlaceIDRequestDetails() {
        AddPlacePojo ap = response.as(AddPlacePojo.class);
        String place_id = ap.getPlace_id();
        GetPlaceRequest = given().spec(get_Request_spec_Details(place_id));

    }

    @Test(priority = 5)
    public void getPlaceAPI() {
        String getPlaceAPIResponse = GetPlaceRequest.when().get("/maps/api/place/get/json").getBody().asString();
        System.out.println(getPlaceAPIResponse);


    }


}
