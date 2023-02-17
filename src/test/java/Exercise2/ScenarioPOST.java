package Exercise2;

import Files.EngageData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ScenarioPOST {

    int id;

    @Test(description = "")
    void testPostRequest() {
        // Pass the correct data in all required fields in the body
        DataPost data2 = new DataPost();
        EngageData engageData = new EngageData();

        data2.setName("Sonarqube");
        data2.setTech_type_id(1);
        data2.setDescription("description");
        data2.setDoc_link("https://jsonformatter.org/");
        data2.setLogo(6);
        String[] asso_tags = {"Framework", "Javaa"};
        data2.setAssoc_tags(asso_tags);

        Response res = given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType("application/json")
                .body(data2)
                .when().post(EngageData.URL);
        //   id = res.jsonPath().getInt("id");
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(dependsOnMethods = {"testPostRequest"})
    void testDeleteRequest() {
//        given().headers("Authorization", "Bearer " + token)
//                .contentType("application/json")
//                .when().delete("https://stage-api-engage.3pillarglobal.com/api/technologies/" + id)
//                .then().statusCode(200).log().all();
//    }
    }
}

