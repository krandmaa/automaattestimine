package weatherapi;


public class WeatherApi {

    private WeatherReport report;

    private static boolean checkLocationFormat(String city, String country) {
        return city != null && !city.equals("") && country != null && !country.equals("");
    }

    public WeatherReport createOneDayWeatherReport(String city, String country, String format) {
        if (!checkLocationFormat(city, country)) {
            ConsoleInput consoleInput = new ConsoleInput();
            city = consoleInput.getCityName();
            country = consoleInput.getCountryName();
        }
        this.report = WeatherReport.createOneDayReport(city, country, format);
        return report;
    }

    public WeatherReport createThreeDayWeatherReport(String city, String country, String format) {
        if (!checkLocationFormat(city, country)) {
            ConsoleInput consoleInput = new ConsoleInput();
            city = consoleInput.getCityName();
            country = consoleInput.getCountryName();
        }
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
