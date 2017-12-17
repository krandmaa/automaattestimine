package weatherapi;


public class WeatherApi {

    private WeatherReport report;

    private static boolean checkLocationFormat(String city, String country) {
        return city != null && !city.equals("") && country != null && !country.equals("");
    }

    public WeatherReport createOneDayWeatherReport(Location location) {
        checkFormat(location);
        this.report = WeatherReport.createOneDayReport(location);
        return report;
    }

    public WeatherReport createThreeDayWeatherReport(Location location) {
        checkFormat(location);
        this.report = WeatherReport.createThreeDayReport(location);
        return report;
    }

    private void checkFormat(Location location) {
        if (!checkLocationFormat(location.getCityName(), location.getCountryCode())) {
            System.out.println("\nSome data is incorrect for " + location.getCityName() + ", please specify:");
            ConsoleInput consoleInput = new ConsoleInput(location);
            location.setCityName(consoleInput.getCityName());
            location.setCountryCode(consoleInput.getCountryName());
        }
    }


    public WeatherReport createWeatherReport(double latitude, double longitude) {
        //TODO: implement weather by coordinates.
        return new WeatherReport(latitude, longitude);
    }

    public WeatherReport getReport() {
        return this.report;
    }
}
