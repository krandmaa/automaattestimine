import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testRainAndHumidity {
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
    public void testHumidityBelowHundred(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createThreeDayWeatherReport(location);
            double currentHumidity = report.getCurrentHumidity();
            assertTrue(currentHumidity <= 100 && currentHumidity >= 0);
        } catch (Exception e) {
            e.printStackTrace();
            fail("No data.");
        }
    }


}
