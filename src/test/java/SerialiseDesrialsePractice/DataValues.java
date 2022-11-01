package SerialiseDesrialsePractice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.PrimitiveIterator;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataValues {

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    private String url;
    private String text;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    private int id;
    private String name;
    private String year;
    private String color;
}
