import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CIS255_Vehicle {
    private static Scanner scanner = new Scanner(System.in);
    private static Storage storage = new Storage();
    private static String fileName = "jOlive1 Vehicle Matrix.csv";

//Switch Statements for Main Menu selection

    public static void main(String[] args) {
        while (true) {
            displayMainMenu();
            int choice = getUserChoice(1, 4);

            switch (choice) {
                case 1:
                    handleCreateVehicle();
                    break;
                case 2:
                    handleDisplayVehicles();
                    break;
                case 3:
                    FileHandler.saveToCSV(storage.getVehicles(), fileName);
                    System.out.println("Vehicles saved to CSV file successfully!");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
    }
    
//Main Menu

    private static void displayMainMenu() {
        System.out.println("==== MENU ====");
        System.out.println("1. Create Vehicle");
        System.out.println("2. Show Vehicles");
        System.out.println("3. Save to file");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
//Code to limit selection and validation

    private static int getUserChoice(int minChoice, int maxChoice) {
        while (true) {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice >= minChoice && choice <= maxChoice) {
                return choice;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine(); 
            System.out.println("Invalid input! Please enter a number.");
        }
    }
    
    //Switch Statements for Create Vehicle Menu selection
}
    private static void handleCreateVehicle() {
        displayCreateVehicleMenu();
        int typeChoice = getUserChoice(1, 4);

        switch (typeChoice) {
            case 1:
                handleCreateType(Type.SEDAN);
                return;
            case 2:
                handleCreateType(Type.COUPE);
                return;
            case 3:
                handleCreateType(Type.TRUCK);
                return;
            case 4:
                return; // Go back to the main menu
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void displayCreateVehicleMenu() {
        System.out.println("==== CREATE VEHICLE ====");
        System.out.println("1. Sedan");
        System.out.println("2. Coupe");
        System.out.println("3. Truck");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }
    
    //Switch Statements for Type Menu selection

    private static void handleCreateType(Type type) {
        displayCreateTypeMenu(type);
        int makeChoice = getUserChoice(1, (type == Type.TRUCK || type == Type.COUPE) ? 5 : 6);

        switch (makeChoice) {
            case 1:
                createVehicle(type, Make.FORD);
                return;
            case 2:
                createVehicle(type, Make.DODGE);
                return;
            case 3:
                createVehicle(type, Make.HONDA);
                return;
            case 4:
                createVehicle(type, Make.TOYOTA);
                return;
            case 5:
               if (type == Type.TRUCK || type == Type.COUPE) { // Code to remove Tesla since it is an exception
                return;
            }  else { // Create a Tesla option if Sedan is selected 
                createVehicle(type, Make.TESLA);
                return;
            }    
            case 6:
                return; 
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void displayCreateTypeMenu(Type type) {
        System.out.println("==== CREATE " + type + " ====");
        System.out.println("1. Ford");
        System.out.println("2. Dodge");
        System.out.println("3. Honda");
        System.out.println("4. Toyota");
        if (type != Type.TRUCK && type != Type.COUPE) { // Only add Tesla as an option if the type isn't Coupe
        System.out.println("5. Tesla");
    }
    System.out.println((type == Type.TRUCK || type == Type.COUPE) ? "5. Back to Main Menu" : "6. Back to Main Menu");
    System.out.print("Enter your choice: ");
}

// Entries for variables with limits and validation and uses Enums EngineType, Color, DoorCount

    private static void createVehicle(Type type, Make make) {
        EngineType engineType;
        while (true) {
            System.out.println("Enter Engine Type (Gas, Diesel, Electric, Hybrid):");
            try {
                engineType = EngineType.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Engine Type! Please try again.");
            }
        }

        Color color;
        while (true) {
            System.out.println("Enter Color (Black, White, Silver):");
            try {
                color = Color.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Color! Please try again.");
            }
        }

        DoorCount doorCount;
        while (true) {
            System.out.println("Enter Door Count (Two or Four):");
            try {
                doorCount = DoorCount.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Door Count! Please try again.");
            }
        }

        int year;
        while (true) {
            System.out.println("Enter Year:");
            try {
                year = scanner.nextInt();
                scanner.nextLine();

                if (year < 1886 || year > LocalDate.now().getYear()) {
                    System.out.println("Invalid Year! Please enter a year between 1886 and " + LocalDate.now().getYear() + ".");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Year! Please enter a valid year.");
                scanner.nextLine();
            }
        }
Vehicle vehicle = null;  // Initialize the vehicle variable

switch (type) {

    //Sedan Models
    case SEDAN:
        boolean isValidModel = false;

        while (!isValidModel) {
            if (make == Make.HONDA) {
                System.out.println("Enter Model (Accord, Civic or Insight):");
                String model = scanner.nextLine().toUpperCase();

                if (model.equals("ACCORD")) {
                    vehicle = new AccordSedan(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("CIVIC")) {
                    vehicle = new CivicSedan(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("INSIGHT")) {
                    vehicle = new Insight(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else {
                    System.out.println("Invalid model for Honda Sedan. Please try again.");
                }

            } else if (make == Make.FORD) {
                System.out.println("Enter Model (Focus, Fusion or Taurus):");
                String model = scanner.nextLine().toUpperCase();

                if (model.equals("FOCUS")) {
                    vehicle = new Focus(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("FUSION")) {
                    vehicle = new Fusion(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("TAURUS")) {
                    vehicle = new Taurus(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else {
                    System.out.println("Invalid model for Ford Sedan. Please try again.");
                }

            } else if (make == Make.DODGE) {
                System.out.println("Enter Model (Charger, Avenger or Dart):");
                String model = scanner.nextLine().toUpperCase();

                if (model.equals("CHARGER")) {
                    vehicle = new Charger(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("AVENGER")) {
                    vehicle = new Avenger(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("DART")) {
                    vehicle = new Dart(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else {
                    System.out.println("Invalid model for Dodge Sedan. Please try again.");
                }

            } else if (make == Make.TOYOTA) {
                System.out.println("Enter Model (Camry, Corolla or Yaris):");
                String model = scanner.nextLine().toUpperCase();

                if (model.equals("CAMRY")) {
                    vehicle = new Camry(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("COROLLA")) {
                    vehicle = new Corolla(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("YARIS")) {
                    vehicle = new Yaris(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else {
                    System.out.println("Invalid model for Toyota Sedan. Please try again.");
                }

            } else if (make == Make.TESLA) {
                System.out.println("Enter Model (Model S or Model 3):");
                String model = scanner.nextLine().toUpperCase();

                if (model.equals("MODEL S")) {
                    vehicle = new ModelS(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else if (model.equals("MODEL 3")) {
                    vehicle = new Model3(make.toString(), engineType, color, doorCount, year);
                    isValidModel = true;
                } else {
                    System.out.println("Invalid model for Tesla Sedan. Please try again.");
                }

            } else {
                System.out.println("Invalid make for Sedan. Please try again.");
            }
        }

        break;


//Coupe Models
    
      case COUPE:
    boolean validInput = false;
    while (!validInput) {
        if (make == Make.HONDA) {
            System.out.println("Enter Model (Accord, Civic, or CRZ):");
            String model = scanner.nextLine().toUpperCase();
            switch (model) {
                case "ACCORD":
                    vehicle = new AccordCoupe(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "CIVIC":
                    vehicle = new CivicCoupe(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "CRZ":
                    vehicle = new Crz(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid model for Honda Coupe. Please try again.");
            }
        } else if (make == Make.FORD) {
            System.out.println("Enter Model (Mustang):");
            String model = scanner.nextLine().toUpperCase();
            if ("MUSTANG".equals(model)) {
                vehicle = new Mustang(make.toString(), engineType, color, doorCount, year);
                validInput = true;
            } else {
                System.out.println("Invalid model for Ford Coupe. Please try again.");
            }
        } else if (make == Make.TOYOTA) {
            System.out.println("Enter Model (EightySix, Supra, or GR86):");
            String model = scanner.nextLine().toUpperCase();
            switch (model) {
                case "EIGHTYSIX":
                    vehicle = new EightySix(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "SUPRA":
                    vehicle = new Supra(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "GR86":
                    vehicle = new GR86(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid model for Toyota Coupe. Please try again.");
            }
        } else if (make == Make.DODGE) {
            System.out.println("Enter Model (Challenger):");
            String model = scanner.nextLine().toUpperCase();
            if ("CHALLENGER".equals(model)) {
                vehicle = new Challenger(make.toString(), engineType, color, doorCount, year);
                validInput = true;
            } else {
                System.out.println("Invalid model for Dodge Coupe. Please try again.");
            }
        } else {
            System.out.println("Invalid make for Coupe. Please try again.");
        }
    }
    break;

 
//Truck Models
   
    case TRUCK:
    validInput = false;
    while (!validInput) {
        if (make == Make.FORD) {
            System.out.println("Enter Model (F150, F250 or Maverick):");
            String model = scanner.nextLine().toUpperCase();
            switch (model) {
                case "F150":
                    vehicle = new F150(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "F250":
                    vehicle = new F250(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "MAVERICK":
                    vehicle = new Maverick(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid model for Ford Truck. Please try again.");
            }
        } else if (make == Make.TOYOTA) {
            System.out.println("Enter Model (Tacoma or Tundra):");
            String model = scanner.nextLine().toUpperCase();
            switch (model) {
                case "TACOMA":
                    vehicle = new Tacoma(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "TUNDRA":
                    vehicle = new Tundra(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid model for Toyota Truck. Please try again.");
            }
        } else if (make == Make.DODGE) {
            System.out.println("Enter Model (Ram 1500 or Ram 2500):");
            String model = scanner.nextLine().toUpperCase();
            switch (model) {
                case "RAM 1500":
                    vehicle = new Ram1500(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                case "RAM 2500":
                    vehicle = new Ram2500(make.toString(), engineType, color, doorCount, year);
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid model for Dodge Truck. Please try again.");
            }
        } else if (make == Make.HONDA) {
            System.out.println("Enter Model (Ridgeline):");
            String model = scanner.nextLine().toUpperCase();
            if ("RIDGELINE".equals(model)) {
                vehicle = new Ridgeline(make.toString(), engineType, color, doorCount, year);
                validInput = true;
            } else {
                System.out.println("Invalid model for Honda Truck. Please try again.");
            }
        } else {
            System.out.println("Invalid make for Truck. Please try again.");
        }
    }
    break;

    default:
        throw new IllegalArgumentException("Invalid type");
}

        storage.addVehicle(vehicle);
        System.out.println("Vehicle created successfully!");
    }

// code to display the vehicles in Pipe Delimited

    private static void handleDisplayVehicles() {
    System.out.println("==== VEHICLES ====");
    for (Vehicle v : storage.getVehicles()) {
        String vehicleData = v.getMake() + "|" +
                             v.getType() + "|" +
                             v.getModel() + "|" +
                             v.getYear() + "|" +
                             v.getColor() + "|" +
                             v.getEngineType() + "|" +
                             v.getDoorCount() + "|";

        System.out.println(vehicleData);
    }
  } 
}
