import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class getWindDegreeInOneCircleTest {
    @Test
    public void WindDegreeAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            double degree = report.getDayWindDegree();
            assertTrue(degree < 360 && degree >= 0);
        } catch (Exception e) {
            fail("Wind degree not less than 360 degrees.");
        }
    }
}
