import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

public class FileWriter  {

    public void Write(String message, String directory) throws IOException {
        java.io.FileWriter fichero = new java.io.FileWriter(directory + "/" +getFileName(message)+ ".json", true);
        fichero.write(message+"\n");
        fichero.close();
    }

    public String getFileName(String message){
        JsonObject jsonObject = new Gson().fromJson(message, JsonObject.class);
        Instant time = Instant.parse(jsonObject.get("ts").getAsString());
        String year = String.valueOf(time.atZone(ZoneId.systemDefault()).getYear());
        String month = String.valueOf(time.atZone(ZoneId.systemDefault()).getMonthValue());
        String day = String.valueOf(time.atZone(ZoneId.systemDefault()).getDayOfMonth());
        String hour = String.valueOf(time.atZone(ZoneId.systemDefault()).getHour());
        return year + "" + month + "" + day + "" + hour;
    }
}