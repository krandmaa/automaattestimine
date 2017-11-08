package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LocationFileReader {

    private String fileName = "Input.txt";

    public LocationFileReader() {
    }

    public String[] readLocationFromFile() throws IOException {
        // If reading fails, throw Exception
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        return reader.readLine().split(",");
    }
}
