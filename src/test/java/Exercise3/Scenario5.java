package Exercise3;

import Exercise2.DataPost;
import Files.EngageData;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scenario5 {
    int id;
    String name = RandomStringUtils.randomAlphabetic(5);
    int tech_id = EngageData.TECH_ID;
    String Ass_tags[] = EngageData.ASSO_TAGS;
    String descriptionData = EngageData.DESCRIPTION_DATA;

    @Test(priority = 1)
    void testPostRequest() {
        DataPost data = new DataPost();

        data.setName(EngageData.NAME);
        data.setTech_type_id(EngageData.TECH_ID);
        data.setDescription(EngageData.DESCRIPTION_DATA);
        data.setDoc_link(EngageData.DOC_LINK);
        data.setLogo(EngageData.LOGO);
        data.setAssoc_tags(EngageData.ASSO_TAGS);

        id = given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data)
                .when().post(EngageData.URL)
                .jsonPath().getInt("id");

    }

    @Test(description = "Pass the data in the body without tech_type_id", dependsOnMethods = "testPostRequest", priority = 2)
    void testPutRequest() {

        DataPost data2 = new DataPost();
        data2.setName(name);
        data2.setTech_type_id(EngageData.TECH_ID);
        data2.setDescription(descriptionData);
        data2.setDoc_link(EngageData.DOC_LINK);
        data2.setLogo(EngageData.LOGO);
        data2.setAssoc_tags(EngageData.ASSO_TAGS);

        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data2)
                .when().put(EngageData.URL + id)
                .then().statusCode(200).log().all();
    }

    @Test(dependsOnMethods = {"testPutRequest"}, priority = 3)
    void testGetData() {
        Response res = given().headers("Authorization", "Bearer " + EngageData.TOKEN).contentType(EngageData.CONTENT_TYPE)
                .when().get(EngageData.URL + id);
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.jsonPath().get("name"), name);
        Assert.assertEquals(res.jsonPath().get("tech_description"), descriptionData);
//        Assert.assertEquals(res.jsonPath().get("tech_id"), tech_id);
//        Assert.assertEquals(res.jsonPath().get("tech_description"), descriptionData);
    }

    @Test(description = "delete the above entered data", dependsOnMethods = "testPostRequest", priority = 4)
    void testDeleteRequest() {
        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .when().delete(EngageData.URL + id)
                .then().statusCode(200).log().all();
    }
}
