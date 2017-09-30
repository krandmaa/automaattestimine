import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertTrue;

public class humidityBelowHundredTest {
    @Test
    public void testHumidityBelowHundred(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            double currentHumidity = report.getCurrentHumidity();
            assertTrue(currentHumidity <= 100 && currentHumidity >= 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
