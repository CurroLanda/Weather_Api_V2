import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;

public class Sensor {

    public String GetWeather(){
        try {
            Client client = ClientBuilder.newClient();
            String url = "https://api.openweathermap.org/data/2.5/weather?id=2515270&appid=2d17f215bf790964b05793c0f31c1b30&units=metric&lang=es";
            WebTarget target = client.target(url);
            Invocation.Builder petition = target.request();
            javax.ws.rs.core.Response post = petition.post(Entity.json(""));
            String response = post.readEntity(String.class);
            checkStatus(post);

            return response;
        }catch (Exception e) {
            return e.toString();
        }
    }

    public static void checkStatus(@org.jetbrains.annotations.NotNull Response post){
        if (post.getStatus() != 200) {
            System.out.println("Algún error ha ocurrido...");
        }
    }
}