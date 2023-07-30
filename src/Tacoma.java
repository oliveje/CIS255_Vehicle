public class Tacoma extends VehicleType {
    public Tacoma(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Tacoma");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}