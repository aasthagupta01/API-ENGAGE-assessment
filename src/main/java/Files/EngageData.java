package Files;

import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class EngageData {

    public static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOiIyMDIzLTAyLTI0VDE3OjMwOjEzLjg0M1oiLCJ1c2VybmFtZSI6ImFhc3RoYS5ndXB0YUAzcGlsbGFyZ2xvYmFsLmNvbSJ9.uaGvXk-z6x199nIP3EtwX7BO8NZJFASr0yH3wufbhfbgk5t2CmUjasz4N9oPtv1RBVjXcPapIgkRwVzqxJMWOg";
    public static String URL = "https://stage-api-engage.3pillarglobal.com/api/technologies/";
    public static String CONTENT_TYPE = "application/json";
    public static String NAME = RandomStringUtils.randomAlphabetic(10);
    public static String[] ASSO_TAGS = {"Framework", "Angular", "Java"};
    public static int TECH_ID = new Random().nextInt(4)+1;
    public static int LOGO = new Random().nextInt(15)+1;
    public static String DOC_LINK = "https://jsonformatter.org/";
    public static String DESCRIPTION_DATA = "description data";


}
