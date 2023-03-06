package Exercise3;

import Exercise2.DataPost;
import Files.EngageData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scenario3 {
    int id;
    String name = EngageData.NAME;
    int tech_id = EngageData.TECH_ID;
    String Ass_tags[] = EngageData.ASSO_TAGS;


    @Test(priority = 1)
    void testPostRequest() {
        DataPost data = new DataPost();

        data.setName(name);
        data.setTech_type_id(tech_id);
        data.setDescription(EngageData.DESCRIPTION_DATA);
        data.setDoc_link(EngageData.DOC_LINK);
        data.setLogo(EngageData.LOGO);
        data.setAssoc_tags(Ass_tags);

        id = given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data)
                .when().post(EngageData.URL)
                .jsonPath().getInt("id");

    }

    @Test(description = "Pass the Existing data (duplicate data) into the body", dependsOnMethods = "testPostRequest", priority = 2)
    void testPutRequest() {

        DataPost data2 = new DataPost();
        data2.setName(name);
        data2.setTech_type_id(tech_id);
        data2.setDescription(EngageData.DESCRIPTION_DATA);
        data2.setDoc_link(EngageData.DOC_LINK);
        data2.setLogo(EngageData.LOGO);
        data2.setAssoc_tags(Ass_tags);

        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data2)
                .when().put(EngageData.URL + id)
                .then().statusCode(409).log().all();
    }

    @Test(description = "delete the above entered data", dependsOnMethods = "testPostRequest", priority = 3)
    void testDeleteRequest() {
        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .when().delete(EngageData.URL + id)
                .then().statusCode(200).log().all();
    }
}
