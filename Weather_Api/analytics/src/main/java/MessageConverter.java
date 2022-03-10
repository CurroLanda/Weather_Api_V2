import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.time.Instant;

public class MessageConverter {
    public String rawJson;

    public MessageConverter(String rawJson) {
        this.rawJson = rawJson;
    }

    public Weather extract(){
        JsonObject jsonString = new Gson().fromJson(this.rawJson, JsonObject.class);
        Instant now = Instant.parse(jsonString.get("ts").getAsString());
        JsonObject coord = jsonString.get("coord").getAsJsonObject();

        return new Weather()
                .setTs(now.toEpochMilli())
                .setLat(coord.get("lat").getAsDouble())
                .setLon(coord.get("lon").getAsDouble())
                .setWeather(jsonString.get("weather").getAsString())
                .setTemp( jsonString.get("temp").getAsDouble())
                .setWindDir(jsonString.get("windDir").getAsInt())
                .setWind(jsonString.get("wind").getAsDouble())
                .setHumidity(jsonString.get("humidity").getAsDouble())
                .setPressure(jsonString.get("pressure").getAsDouble());
    }
}