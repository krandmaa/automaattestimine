import org.json.JSONObject;
import org.junit.Test;
import urlfilereader.UrlFileReader;

import static org.junit.Assert.assertTrue;

public class testFileReader {
    private String apiUrl = "http://api.openweathermap.org/data/2.5/forecast" +
            "?q={TALLINN},{EE}&units={METRIC}&APPID=42b13007be0d337745591f429f617215";
    
    @Test
    public void testReadApiUrlNotNullContent() {
        UrlFileReader urlFileReader = new UrlFileReader();
        JSONObject jsonFile = null;
        try {
            String urlReadContent = urlFileReader.readFromUrl(apiUrl);
            jsonFile = new JSONObject(urlReadContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(jsonFile != null);
    }
}
