import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class httpUtilityTest {
    @Test
    public void testHttpConnectionToApi() {
        try {
            String apiUrl = "<API REQUEST URL>";
            HttpURLConnection con = HttpUtility.makeHttpGetRequest(apiUrl);

            assertEquals(con.getResponseCode(), 200);
        } catch (IOException e) {
            fail("Http connection threw error: " + e.getLocalizedMessage());
        }

    }
}
