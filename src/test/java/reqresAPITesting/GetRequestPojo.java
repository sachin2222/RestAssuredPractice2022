package reqresAPITesting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRequestPojo {

    private GetRequestDataPojo data;
    public GetRequestDataPojo getData() {
        return data;
    }

    public void setData(GetRequestDataPojo data) {
        this.data = data;
    }







}
