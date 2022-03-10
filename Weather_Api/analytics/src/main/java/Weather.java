import com.google.gson.JsonObject;

public class Weather {
    private long ts;
    private JsonObject coord;
    private double lat;
    private double lon;
    private String weather;
    private double temp;
    private int windDir;
    private double wind;
    private double humidity;
    private double pressure;

    public long getTs() {
        return ts;
    }

    public Weather setTs(long ts) {
        this.ts = ts;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Weather setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public Weather setLat(double lat) {
        this.lat = lat;
        return this;
    }


    public String getWeather() {
        return weather;
    }

    public Weather setWeather(String weather) {
        this.weather = weather;
        return this;
    }

    public double getTemp() {
        return temp;
    }

    public Weather setTemp(double temp) {
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

    public double getWind() {
        return wind;
    }

    public Weather setWind(double wind) {
        this.wind = wind;
        return this;
    }

    public double getHumidity() {
        return humidity;
    }

    public Weather setHumidity(double humidity) {
        this.humidity = humidity;
        return this;
    }

    public double getPressure() {
        return pressure;
    }

    public Weather setPressure(double pressure) {
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

        public Builder lat(Double lat){
            weather.setLat(lat);
            return this;
        }

        public Builder lon(Double lon){
            weather.setLon(lon);
            return this;
        }

        public Builder ts(long ts){
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

        public Builder humidity(double humidity){
            weather.setHumidity(humidity);
            return this;
        }

        public Builder pressure(double pressure){
            weather.setPressure(pressure);
            return this;
        }

    }
}