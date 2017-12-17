package weatherapi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    private String cityName;
    private String countryName;
    private Location location;

    public ConsoleInput(Location location) {
        this.cityName = null;
        this.countryName = null;
        this.location = location;
        getConsoleInput();
    }

    private void getConsoleInput() {
        while (countryName == null || cityName == null || countryName.equals("") || cityName.equals("")) {
            try {
                cityName = this.getConsoleInputCity();
                countryName = this.getConsoleInputCountry();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Invalid country or city entered.");
            }
        }
        location.setCityName(cityName);
        location.setCountryCode(countryName);
    }

    private String getConsoleInputCity() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter city name: ");
        return consoleReader.readLine();
    }

    private String getConsoleInputCountry() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter country code: (x if don't know)");
        return consoleReader.readLine();
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }
}
