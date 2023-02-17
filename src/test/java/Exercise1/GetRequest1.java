package Exercise1;

import Files.EngageData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest1 {

    EngageData engageData = new EngageData();

    @Test
    public void testGetRequest(){

        given().headers("Authorization", "Bearer " + EngageData.TOKEN).contentType("application/json")
                .when().get(EngageData.URL)
                .then().statusCode(200).log().all();
    }

    @Test
    public void testGetIDRequest(){
        Response response = given().headers("Authorization","Bearer " + EngageData.TOKEN).contentType("application/json")
                .when().get(EngageData.URL +"/1650");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals((Integer) response.jsonPath().get("tech_type_id"), 1);
        Assert.assertEquals(response.jsonPath().get("name"),"DevExpress");
    }

}
