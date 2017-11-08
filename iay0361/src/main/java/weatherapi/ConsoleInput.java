package weatherapi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    private String cityName;
    private String countryName;

    public ConsoleInput() {
        this.cityName = null;
        this.countryName = null;
        getConsoleInput();
    }

    private void getConsoleInput() {
        while (countryName == null || cityName == null || countryName.equals("") || cityName.equals("")) {
            System.out.println("\n\n");
            try {
                cityName = this.getConsoleInputCity();
                countryName = this.getConsoleInputCountry();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Invalid country or city entered.");
            }
        }
        Location.setCityName(cityName);
        Location.setCountryCode(countryName);
    }

    private String getConsoleInputCity() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter city code: ");
        return consoleReader.readLine();
    }

    private String getConsoleInputCountry() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter country code: ");
        return consoleReader.readLine();
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }
}
