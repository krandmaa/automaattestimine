package connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtility {
    public static HttpURLConnection makeHttpGetRequest(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }
}
