import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class getWindDegreeAboveZeroTest {
    @Test
    public void WindDegreeAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            double degree = api.getDayWindDegree().get(0);
            assertTrue(degree >= 0);
        } catch (Exception e) {
            fail("Found negative wind degree.");
        }
    }
}
