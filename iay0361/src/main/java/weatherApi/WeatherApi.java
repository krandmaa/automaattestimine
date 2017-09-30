package weatherApi;


public class WeatherApi {

    public WeatherReport createWeatherReport(String city, String country, String format) {
        return new WeatherReport(city, country, format);
    }

    public String getForecastFileName() {
        return null;
    }


    public WeatherReport createWeatherReport(double latitude, double longitude) {
        return new WeatherReport(latitude, longitude);
    }
}
