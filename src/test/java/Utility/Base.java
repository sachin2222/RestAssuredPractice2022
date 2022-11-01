package Utility;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Base {

    public static RequestSpecification get_Request_spec_Details_for_AddPlaceAPI(){
        RequestSpecification requestSpecification=new RequestSpecBuilder()
                .setBaseUri("http://rahulshettyacademy.com/")
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .addQueryParam("key","qaclick123")
                .build();

        return requestSpecification;

    }

    public static RequestSpecification get_Request_spec_Details(String place_id){
        RequestSpecification requestSpecificationGetPlace=new RequestSpecBuilder()
                .setBaseUri("http://rahulshettyacademy.com/").addQueryParam("key","qaclick123")
                .addQueryParam("place_id",place_id)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .build();

        return requestSpecificationGetPlace;

    }



}
