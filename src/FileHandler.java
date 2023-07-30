import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {
    private static final String CSV_FILE_NAME = "jOlive1 Vehicle Matrix.csv";
    private static final String CSV_DELIMITER = "|";
    private static final String NEW_LINE = "\n"; 

    public static void saveToCSV(List<Vehicle> vehicles, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Write the CSV header
            writer.println("Make|Type|Model|Door Count|Engine Type|Color|Year");

            // Writes vehicle data to the CSV file with Pipe
            for (Vehicle vehicle : vehicles) {
                writer.println(
                        vehicle.getMake() + CSV_DELIMITER +
                        vehicle.getType() + CSV_DELIMITER +
                        vehicle.getModel() + CSV_DELIMITER +
                        vehicle.getDoorCount() + CSV_DELIMITER +
                        vehicle.getEngineType() + CSV_DELIMITER +
                        vehicle.getColor() + CSV_DELIMITER +
                        vehicle.getYear()
                );
                 writer.print(NEW_LINE);
            }

            System.out.println("Vehicles saved to CSV file successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while saving vehicles to CSV file.");
            e.printStackTrace();
        }
    }

    public static List<Vehicle> loadFromFile(String fileName) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            vehicles = (List<Vehicle>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
