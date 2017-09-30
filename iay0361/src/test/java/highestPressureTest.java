import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertTrue;

public class highestPressureTest {
    @Test
    public void highestPressureNotTooHigh(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            double currentPressure = report.getCurrentPressure();
            assertTrue(currentPressure <= 1100 && currentPressure > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
