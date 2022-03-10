import java.io.File;

public class DirectoryManager {
    public String directory;

    public void setWorkingDirectory(String directory){
        File workDirectory = new File(directory +"/datalake/events/sensor.Weather");
        workDirectory.mkdirs();
        this.directory= workDirectory.getAbsolutePath();
    }

    public String getWorkindDirectory(){
        return directory;
    }
}