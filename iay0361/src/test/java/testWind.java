import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testWind {
    Location location;

    @Before
    public void setUp() {
        this.location = new Location();
        this.location.setCityName("Tallinn");
        this.location.setCountryCode("EE");
        this.location.setFormat("metric");
    }

    @After
    public void tearDown() {
        this.location = null;
    }
    @Test
    public void testWindSpeedAboveZero(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport(location);
            double currentWindSpeed = report.getDayWindSpeed();
            assertTrue(currentWindSpeed >= 0);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Wind degree negative or not less than 360 degrees.");
        }
    }

    @Test
    public void WindDegreeAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport(location);
            double degree = report.getDayWindDegree();
            assertTrue(degree < 360 && degree >= 0);
        } catch (Exception e) {
            fail("Wind degree negative or not less than 360 degrees.");
        }
    }
}
