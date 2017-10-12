import org.junit.Test;
import weatherapi.WeatherApi;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class forecastFileFormatTest {
    @Test
    public void TestForecastFileFormat() {
        try {
            WeatherApi api = new WeatherApi();
            String fileName = api.getForecastFileName();
            assertTrue(fileName.toLowerCase().endsWith("xml") || fileName.toLowerCase().endsWith("json"));
        } catch (Exception e) {
            fail("Could not get forecast file in proper format.");
        }
    }
}
