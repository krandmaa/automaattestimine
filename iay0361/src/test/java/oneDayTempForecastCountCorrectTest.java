import org.junit.Test;
import weatherApi.WeatherApi;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class oneDayTempForecastCountCorrectTest {
    @Test
    public void GetOneDayTemperaturesCountCorrect() {
        try {
            WeatherApi api = new WeatherApi();
            ArrayList<Double> oneDayTemps = api.getOneDayTemperatures();

            assertTrue(oneDayTemps.size() <= 8);
        } catch (Exception e) {
            fail("Too many temperature results for one day.");
        }
    }
}
