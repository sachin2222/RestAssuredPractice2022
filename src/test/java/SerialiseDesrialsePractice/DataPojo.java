package SerialiseDesrialsePractice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPojo {
    public List<DataValues> getData() {
        return data;
    }

    private List<DataValues> data;

    public DataValues getSupport() {
        return support;
    }

    private DataValues support;

}
