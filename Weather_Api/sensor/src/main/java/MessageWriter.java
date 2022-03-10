import com.google.gson.Gson;

public class MessageWriter {
    public String Write(Weather weatherRaw){
        Gson json = new Gson();
        return json.toJson(weatherRaw);
    }
}