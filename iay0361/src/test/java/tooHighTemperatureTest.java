import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class tooHighTemperatureTest {
    @Test
    public void testTemperatureNotTooHot() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> threeDayTemperatures = report.getThreeDayTemperatures();
            int abnormallyHotTemperature = 150;

            for (double temp : threeDayTemperatures) {
                if (temp >= abnormallyHotTemperature) {
                    fail("Higher than possible temperature found.");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
