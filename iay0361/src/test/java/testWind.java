import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testWind {
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

    @Test
    public void WindDegreeAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            double degree = report.getDayWindDegree();
            assertTrue(degree < 360 && degree >= 0);
        } catch (Exception e) {
            fail("Wind degree negative or not less than 360 degrees.");
        }
    }
}
