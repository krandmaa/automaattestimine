import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;

public class windSpeedAboveZeroTest {
    @Test
    public void testWindSpeedAboveZero(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            double currentWindSpeed = report.getDayWindSpeed();
            assertTrue(currentWindSpeed >= 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
