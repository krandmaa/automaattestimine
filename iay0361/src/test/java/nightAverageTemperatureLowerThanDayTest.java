import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;


import static org.junit.Assert.assertTrue;


public class nightAverageTemperatureLowerThanDayTest {
    @Test
    public void testDailyAverageAboveNightlyTemperature() {
        WeatherApi api = new WeatherApi();
        WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
        double dayAverageTemperature = report.getDayTemp();
        double nightAverageTemperature = report.getNightTemp();

        assertTrue(dayAverageTemperature >= nightAverageTemperature);
    }
}
