import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Home {
    private static final String YOUR_DOMAIN_NAME = "YOUR DOMAIN NAME"; //TODO put your domain name here

    public static void main(String[] args) {

        try {
            JsonNode jsonNode = sendSimpleMessage();
            System.out.println(jsonNode.toString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }



    public static JsonNode sendSimpleMessage() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages")
                .basicAuth("api", APIK.API_KEY)
                .field("from", "Excited User LemubitStudents@lemubit.com")
                .field("to", "YOUR_EMAIL")//TODO put your emails here
                .field("subject", "Hello From Lemubit Students")
                .field("text", "Testing Lemubit Students")
                .asJson();

        return request.getBody();
    }

}
