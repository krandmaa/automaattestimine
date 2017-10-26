package urlfilereader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlFileReader {
    public UrlFileReader() {
    }

    public String readFromUrl(String url) throws Exception {
        URL readUrl = new URL(url);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(readUrl.openStream()));
        String tempLine;
        StringBuilder content = new StringBuilder();

        while ((tempLine = reader.readLine()) != null)
            content.append(tempLine);
        reader.close();

        return content.toString();
    }
}
