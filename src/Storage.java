import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Vehicle> vehicles;

    public Storage() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
