import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertTrue;

public class lowestPressureTest {
    @Test
    public void testPressureNotTooLow(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            double currentPressure = report.getCurrentPressure();
            assertTrue(currentPressure >= 900);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
