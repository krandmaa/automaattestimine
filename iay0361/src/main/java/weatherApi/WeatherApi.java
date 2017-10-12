package weatherapi;


public class WeatherApi {

    private WeatherReport report;

    public WeatherReport createWeatherReport(String city, String country, String format) {
        this.report = new WeatherReport(city, country, format);
        return report;
    }

    public String getForecastFileName() {
        return null;
    }


    public WeatherReport createWeatherReport(double latitude, double longitude) {
        return new WeatherReport(latitude, longitude);
    }
}
