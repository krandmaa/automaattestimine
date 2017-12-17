import connection.HttpUtility;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class testHttpUtility {
    @Test
    public void testHttpConnectionToApi() {
        try {
            String apiUrl = "http://api.openweathermap.org/data/2.5/forecast" +
                    "?q=TALLINN,EE&units=METRIC&APPID=42b13007be0d337745591f429f617215";
            HttpURLConnection con = HttpUtility.makeHttpGetRequest(apiUrl);
            assertEquals(con.getResponseCode(), 200);
        } catch (IOException e) {
            fail("Http connection threw error: " + e.getLocalizedMessage());
        }

    }
}
