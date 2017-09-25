import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class getWindDegreeInOneCircleTest {
    @Test
    public void WindDegreeAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            double degree = api.getDayWindDegree().get(0);
            assertTrue(degree < 360);
        } catch (Exception e) {
            fail("Wind degree not less than 360 degrees.");
        }
    }
}
