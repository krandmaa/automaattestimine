package weatherapi;

//Store information about location and format.
public class Location {
    private static String cityName = "tallinn";
    private static String countryCode = "ee";
    private static String format = "metric";


    public static String getCityName() {
        return cityName;
    }

    public static void setCityName(String cityName) {
        Location.cityName = cityName;
    }

    public static String getCountryCode() {
        return countryCode;
    }

    public static void setCountryCode(String countryCode) {
        Location.countryCode = countryCode;
    }

    public static String getFormat() {
        return format;
    }

    public static void setFormat(String format) {
        Location.format = format;
    }
}
