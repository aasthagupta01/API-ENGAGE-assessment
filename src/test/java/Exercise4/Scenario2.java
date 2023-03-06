package Exercise4;

import Files.EngageData;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scenario2 {
    int id;
    JSONObject data = new JSONObject();

    @Test
    void testPostRequest() {

        // Pass the correct data in all required fields in the body

        data.put("name", EngageData.NAME);
        data.put("tech_type_id", EngageData.TECH_ID);
        data.put("doc_link", EngageData.DOC_LINK);
        data.put("description", EngageData.DESCRIPTION_DATA);
        data.put("assoc_tags", EngageData.ASSO_TAGS);
        data.put("logo", EngageData.LOGO);

        id = given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data.toString())
                .when().post(EngageData.URL).jsonPath().getInt("id");
        System.out.println(id);
    }

    @Test(dependsOnMethods = {"testPostRequest"}, priority = 2)
    void testDeleteData() {
        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .when().delete(EngageData.URL + id)
                .then().statusCode(200).log().all();
    }
}

