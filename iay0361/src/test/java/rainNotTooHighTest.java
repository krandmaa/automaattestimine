import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class rainNotTooHighTest {
    @Test
    public void TestRainNotTooHighMM() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            double hourRainMM = report.getDayRainMM().get(1);
            assertTrue(hourRainMM <= 20);
        } catch (Exception e) {
            fail("Found too high rain in millimetres for one hour.");
        }
    }
}
