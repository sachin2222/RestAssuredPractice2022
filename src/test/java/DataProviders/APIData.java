package DataProviders;

import org.testng.annotations.DataProvider;

public class APIData {

    @DataProvider(name="AddPlaceAPI",parallel = true)
    public Object[][] addPlaceAPIData(){
        Object addplaceapiBodyData[][]={
                {10,"sector 37","www.tester.com","US",32.09,-12.09,"sachin","8700896892"}
        };

        return addplaceapiBodyData;

    }
}
