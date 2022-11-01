package Payload;

import Pojo.AddPlaceLocationPojo;
import Pojo.AddPlacePojo;

import java.util.ArrayList;
import java.util.List;

public class AddPlacePayload {

    public static AddPlacePojo setPayloadAttributeValues(int accuracy, String address, String website, String language,
                                                 double latitude, double longitude, String name, String phone_number) {
        AddPlacePojo pojo = new AddPlacePojo();
        pojo.setAddress(address);
        pojo.setPhone_number(phone_number);
        pojo.setLanguage(language);
        pojo.setWebsite(website);
        pojo.setAccuracy(accuracy);
        pojo.setName(name);

        List<String> myList = new ArrayList<>();
        myList.add("shoes");
        myList.add("shark");

        AddPlaceLocationPojo addPlaceLocationPojo = new AddPlaceLocationPojo();
        addPlaceLocationPojo.setLat(latitude);
        addPlaceLocationPojo.setLng(longitude);
        pojo.setLocation(addPlaceLocationPojo);

        return pojo;


    }


}
