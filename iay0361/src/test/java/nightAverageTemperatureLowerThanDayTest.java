import org.junit.Test;
import weatherApi.WeatherApi;


import static org.junit.Assert.assertTrue;


public class nightAverageTemperatureLowerThanDayTest {
    @Test
    public void testDailyAverageAboveNightlyTemperature() {
        WeatherApi api = new WeatherApi();
        double dayAverageTemperature = api.getDayAverageTempCelsius();
        double nightAverageTemperature = api.getNightAverageTempCelsius();

        assertTrue(dayAverageTemperature >= nightAverageTemperature);
    }
}
