package Files;

import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class EngageData {

    public static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOiIyMDIzLTAyLTE3VDE2OjM2OjI3LjA5OVoiLCJ1c2VybmFtZSI6ImFhc3RoYS5ndXB0YUAzcGlsbGFyZ2xvYmFsLmNvbSJ9.Cl0Zyt9Z2KQkhsXRQXv62LCB0-PmFmf2E1qcvPmQPgKl8yuPDcmBM551P6GZBiHKp_ShH3vHXVFDHBdsE6vMzA";
    public static String URL = "https://stage-api-engage.3pillarglobal.com/api/technologies/";
    public static String CONTENT_TYPE = "application/json";
    public static String NAME = RandomStringUtils.randomAlphabetic(10);
    public static String[] ASSO_TAGS = {"Framework", "Angular", "Java"};
    public static int TECH_ID = new Random().nextInt(4)+1;
    public static int LOGO = new Random().nextInt(15)+1;
    public static String DOC_LINK = "https://jsonformatter.org/";
    public static String DESCRIPTION_DATA = "description dataaa";





  //  private ArrayList<String> words;
//    public int id = 3;
//    public ArrayList<String> words = new ArrayList();
//    ArrayList<String> arrayListName = new ArrayList<>();

         //   Arrays.asList ("One", "Two", "Three"));


//    public void getRandomWord(){
//        ArrayList<String> list=new ArrayList<String>();
//        list.add("JAVA");
//    }
//        Random rand = new Random();
//        String ab =
//        String randomWord = words.get(rand.nextInt(words.size));
//
//
//    public static String FullData(String name) {
//        return "{\n" +
//                "    \"name\": \""+name+"\",\n" +
//                "    \"tech_type_id\": 3,\n" +
//                "    \"doc_link\": \"https://jsonformatter.org/\",\n" +
//                "    \"description\": \"New description data\",\n" +
//                "    \"assoc_tags\": [\n" +
//                "        \"Framework\",\n" +
//                "        \"Angular\"\n" +
//                "    ],\n" +
//                "    \"logo\": 6\n" +
//                "}";
//    }

}
