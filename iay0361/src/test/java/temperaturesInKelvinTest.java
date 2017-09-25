import org.junit.Test;
import weatherApi.WeatherApi;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class temperaturesInKelvinTest {
    @Test
    public void testTemperaturesInKelvinAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            ArrayList<Double> threeDayTemperatures = api.getThreeDayTemperatures();
            for (double temp : threeDayTemperatures) {
                if (temp <= 0) {
                    fail("Impossible kelvin temperature");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
