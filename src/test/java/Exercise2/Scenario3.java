package Exercise2;

import Files.EngageData;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scenario3 {
    EngageData engageData = new EngageData();
    int id;


    @Test
    void testPostRequest() {
        // Pass the correct data in all required fields in the body
        DataPost data = new DataPost();

        data.setName("TestNameAbccc");
        data.setTech_type_id(3);
        data.setDescription("description dataaa");
        data.setDoc_link("https://jsonformatter.org/");
        String[] asso_tags = {"Framework", "python", "java"};
        data.setAssoc_tags(asso_tags);
        data.setLogo(4);
//
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.header("Authorization", "Bearer " + engageData.token).header("Content-Type","application/json");
//        Response response = requestSpecification.body(EngageData.FullData("testme"))
//                .when().post("https://stage-api-engage.3pillarglobal.com/api/technologies");
//        response.then().log().all().assertThat().statusCode(200);

        Response response = given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType("application/json")
                .body(data)
           //     .body(EngageData.FullData("hellofghv"))
                .when().post(EngageData.URL);
        response.then().log().all().assertThat().statusCode(200);

    }

}

