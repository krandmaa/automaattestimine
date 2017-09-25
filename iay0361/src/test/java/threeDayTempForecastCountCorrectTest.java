import org.junit.Test;
import weatherApi.WeatherApi;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class threeDayTempForecastCountCorrectTest {
    @Test
    public void GetThreeDayTemperaturesCountCorrect() {
        try {
            WeatherApi api = new WeatherApi();
            ArrayList<Double> oneDayTemps = api.getThreeDayTemperatures();

            assertTrue(oneDayTemps.size() <= 24);
        } catch (Exception e) {
            fail("Too many temperature results for three days.");
        }
    }
}
