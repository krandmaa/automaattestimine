import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testPressure {
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
    public void testPressureNotTooLow(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport(location);
            double currentPressure = report.getCurrentPressure();
            assertTrue(currentPressure >= 900);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void highestPressureNotTooHigh(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport(location);
            double currentPressure = report.getCurrentPressure();
            assertTrue(currentPressure <= 1100 && currentPressure > 0);
        } catch (Exception e) {
            fail("Found impossible air pressure.");
            e.printStackTrace();
        }
    }
}
