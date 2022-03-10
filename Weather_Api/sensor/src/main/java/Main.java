import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Sensor weatherObject = new Sensor();
                WeatherExtractor parse = new WeatherExtractor(weatherObject.GetWeather());
                new Send(parse);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 15*60*1000);
    }
}