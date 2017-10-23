package weatherapi;


public class WeatherApi {

    private WeatherReport report;

    public WeatherReport createOneDayWeatherReport(String city, String country, String format) {
        this.report = WeatherReport.createOneDayReport(city, country, format);
        return report;
    }

    public WeatherReport createThreeDayWeatherReport(String city, String country, String format) {
        this.report = WeatherReport.createThreeDayReport(city, country, format);
        return report;
    }

    public String getForecastFileName() {
        return null;
    }


    public WeatherReport createWeatherReport(double latitude, double longitude) {
        //TODO: implement weather by coordinates.
        return new WeatherReport(latitude, longitude);
    }
}
