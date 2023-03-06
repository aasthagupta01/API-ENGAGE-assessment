package Exercise5;

import Files.EngageData;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {
    int id;
    String name = EngageData.NAME;
    int tech_id = EngageData.TECH_ID;
    String Ass_tags[] = EngageData.ASSO_TAGS;
    JSONObject data = new JSONObject();

    @Test
    void testPostRequest() {

        // Pass the correct data in all required fields in the body

        data.put("name", name);
        data.put("tech_type_id", tech_id);
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
    void testGetData() {
        Response res = given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .when().get(EngageData.URL + id);
        Assert.assertEquals(res.jsonPath().get("name"), name);
        Assert.assertEquals((Integer) res.jsonPath().get("tech_type_id"), tech_id);
        Assert.assertEquals(res.jsonPath().get("documentation_link"), EngageData.DOC_LINK);
        Assert.assertEquals(res.jsonPath().get("tech_description"), EngageData.DESCRIPTION_DATA);
        Assert.assertEquals(res.jsonPath().get("associated_tags[0]"), EngageData.ASSO_TAGS[0]);
        Assert.assertEquals(res.jsonPath().get("associated_tags[1]"), EngageData.ASSO_TAGS[1]);
        Assert.assertEquals(res.jsonPath().get("associated_tags[2]"), EngageData.ASSO_TAGS[2]);
        Assert.assertEquals((Integer) res.jsonPath().get("tech_logo"), EngageData.LOGO);
    }

    @Test(dependsOnMethods = {"testPostRequest"}, priority = 3)
    void testDeleteRequest() {
        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .when().delete(EngageData.URL + id)
                .then().statusCode(200).log().all();
    }
}

