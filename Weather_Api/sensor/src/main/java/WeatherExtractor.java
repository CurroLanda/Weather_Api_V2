import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.time.Instant;

public class WeatherExtractor {
    public String rawJson;

    public WeatherExtractor(String rawJson) {
        this.rawJson = rawJson;
    }

    public Weather extract(){
        JsonObject jsonString = new Gson().fromJson(this.rawJson, JsonObject.class);
        JsonObject weather = jsonString.get("weather").getAsJsonArray().get(0).getAsJsonObject();
        JsonObject wind = jsonString.get("wind").getAsJsonObject();
        JsonObject main = jsonString.get("main").getAsJsonObject();
        JsonObject location = jsonString.get("coord").getAsJsonObject();

        return new Weather()
                .setTs(Instant.now().toString())
                .setCoord(location)
                .setWeather(weather.get("main").getAsString())
                .setTemp( main.get("temp").getAsFloat())
                .setWindDir(wind.get("deg").getAsInt())
                .setWind(wind.get("speed").getAsFloat())
                .setHumidity( main.get("humidity").getAsInt())
                .setPressure(main.get("pressure").getAsInt());
    }
}