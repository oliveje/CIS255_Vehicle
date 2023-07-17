import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CIS255_Vehicle {
    private static final String STORAGE_FILE = "jolive1 vehicles.csv";
    private static final String[] HEADER = {"Make", "Type", "Model", "Year", "Engine", "Door Count", "Color"};

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String[]> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n-- Vehicle Menu --");
            System.out.println("1. Create Vehicle");
            System.out.println("2. Show Vehicles");
            System.out.println("3. Save to File");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    displayVehicles();
                    break;
                case 3:
                    saveToStorage();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addVehicle() {
        System.out.println("\n-- Add a Vehicle --");
        System.out.print("Enter the make: ");
        String make = scanner.nextLine();
        System.out.print("Enter the type: ");
        String type = scanner.nextLine();
        System.out.print("Enter the model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the engine: ");
        String engine = scanner.nextLine();
        System.out.print("Enter the door count: ");
        int doorCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the color: ");
        String color = scanner.nextLine();

        String[] vehicle = {make, type, model, String.valueOf(year), engine, String.valueOf(doorCount), color};
        vehicles.add(vehicle);

        System.out.println("Vehicle added successfully!");
    }

    private static void displayVehicles() {
        System.out.println("\n-- Vehicles --");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles added yet.");
            return;
        }

        System.out.println(String.join("| ", HEADER));
        for (String[] vehicle : vehicles) {
        System.out.println(String.join("|", vehicle));
        }
    }

    private static void saveToStorage() {
       
       String storagePath = System.getProperty("user.dir") + "/" + STORAGE_FILE;
       
       
        try (FileWriter writer = new FileWriter(STORAGE_FILE)) {
            // Write CSV header
            writer.write(String.join("|", HEADER) + "\n");

            // Write vehicles data
            for (String[] vehicle : vehicles) {
                writer.write(String.join("|", vehicle) + "\n");
            }

            System.out.println("Vehicles saved to storage successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while saving vehicles to storage.");
            e.printStackTrace();
        }
    }
}