import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class getWindDegreeAboveZeroTest {
    @Test
    public void WindDegreeAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            double degree = report.getDayWindDegree();
            assertTrue(degree >= 0);
        } catch (Exception e) {
            fail("Found negative wind degree.");
        }
    }
}
