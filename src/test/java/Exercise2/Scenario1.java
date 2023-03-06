package Exercise2;

import Files.EngageData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Scenario1 {
    DataPost data = new DataPost();

    @Test(description = "Pass the data in the body without \"name\" in the body")
    public void Scenario1(){

        data.setTech_type_id(EngageData.TECH_ID);
        data.setDescription(EngageData.DESCRIPTION_DATA);
        data.setDoc_link(EngageData.DOC_LINK);
        data.setLogo(EngageData.LOGO);
        data.setAssoc_tags(EngageData.ASSO_TAGS);

        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data)
                .when().post(EngageData.URL)
                .then().statusCode(400).log().all();
    }

    @Test(description = "Pass the data in the body without \"tech_type_id\"in the body")
    public void Scenario2(){

        data.setName(EngageData.NAME);
        data.setDescription(EngageData.DESCRIPTION_DATA);
        data.setDoc_link(EngageData.DOC_LINK);
        data.setLogo(EngageData.LOGO);
        data.setAssoc_tags(EngageData.ASSO_TAGS);

        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data)
                .when().post(EngageData.URL)
                .then().statusCode(400).log().all();
    }

    @Test(description = "Pass the correct data in all required fields in the body")
    public void Scenario3(){

        data.setName(EngageData.NAME);
        data.setTech_type_id(EngageData.TECH_ID);
        data.setDescription(EngageData.DESCRIPTION_DATA);
        data.setDoc_link(EngageData.DOC_LINK);
        data.setLogo(EngageData.LOGO);
        data.setAssoc_tags(EngageData.ASSO_TAGS);

        given().headers("Authorization", "Bearer " + EngageData.TOKEN)
                .contentType(EngageData.CONTENT_TYPE)
                .body(data)
                .when().post(EngageData.URL)
                .then().statusCode(200).log().all();

    }

}
