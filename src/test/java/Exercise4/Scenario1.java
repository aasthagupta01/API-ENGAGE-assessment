package Exercise4;

import Exercise2.DataPost;
import Files.EngageData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scenario1 {
    int id;

    @Test()
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

    @Test(description = "Pass the id in the DELETE request ", dependsOnMethods = "testPostRequest")
    void testDeleteRequest() {
        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .when().delete(EngageData.URL + id)
                .then().statusCode(200).log().all();
    }
}
