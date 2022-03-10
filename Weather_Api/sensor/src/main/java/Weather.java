import com.google.gson.JsonObject;

public class Weather {
    private String ts;
    private JsonObject coord;
    private String weather;
    private Float temp;
    private int windDir;
    private Float wind;
    private int humidity;
    private int pressure;

    public String getTs() {
        return ts;
    }

    public Weather setTs(String ts) {
        this.ts = ts;
        return this;
    }


    public String getWeather() {
        return weather;
    }

    public Weather setWeather(String weather) {
        this.weather = weather;
        return this;
    }

    public Float getTemp() {
        return temp;
    }

    public Weather setTemp(Float temp) {
        this.temp = temp;
        return this;
    }

    public int getWindDir() {
        return windDir;
    }

    public Weather setWindDir(int windDir) {
        this.windDir = windDir;
        return this;
    }

    public Float getWind() {
        return wind;
    }

    public Weather setWind(Float wind) {
        this.wind = wind;
        return this;
    }

    public int getHumidity() {
        return humidity;
    }

    public Weather setHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    public int getPressure() {
        return pressure;
    }

    public Weather setPressure(int pressure) {
        this.pressure = pressure;
        return this;
    }

    public JsonObject getCoord() {
        return coord;
    }

    public Weather setCoord(JsonObject coord) {
        this.coord = coord;
        return this;
    }


    public static class Builder{
        private Weather weather;

        public Builder(){this.weather= new Weather();}

        public Builder coord(JsonObject coord){
            weather.setCoord(coord);
            return this;
        }

        public Builder ts(String ts){
            weather.setTs(ts);
            return this;
        }

        public Builder weatherNow(String weatherNow){
            weather.setWeather(weatherNow);
            return this;
        }

        public Builder temperature(Float temperature){
            weather.setTemp(temperature);
            return this;
        }

        public Builder windDir(int windDir){
            weather.setWindDir(windDir);
            return this;
        }

        public Builder windSpeed(Float windSpeed){
            weather.setWind(windSpeed);
            return this;
        }

        public Builder humidity(int humidity){
            weather.setHumidity(humidity);
            return this;
        }

        public Builder pressure(int pressure){
            weather.setPressure(pressure);
            return this;
        }

    }
}