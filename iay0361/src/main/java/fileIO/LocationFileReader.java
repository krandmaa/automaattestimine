package fileIO;

import weatherapi.Location;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocationFileReader {

    private String fileName = "Input.txt";
    private List<Location> allLocations = new ArrayList<>();

    public LocationFileReader() {
    }

    public void readLocationFromFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                makeLocation(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Locations file not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private void makeLocation(String line) {
        String[] splitLine = line.split(",");
        Location location = new Location();
        location.setCityName(splitLine[0]);
        if (splitLine.length > 1) {
            location.setCountryCode(splitLine[1]);
            if (splitLine.length > 2) {
                location.setFormat(splitLine[2]);
            }
        }
        this.allLocations.add(location);
    }

    public List<Location> getAllLocations() {
        return allLocations;
    }
}
