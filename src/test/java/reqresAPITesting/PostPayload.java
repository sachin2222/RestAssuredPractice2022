package reqresAPITesting;

public class PostPayload {

    public static ReqresPostPojo setpojoDetails(){
        ReqresPostPojo postPojo=new ReqresPostPojo();
        postPojo.setName("sachin");
        postPojo.setJob("SDET");

        return postPojo;

    }
}
