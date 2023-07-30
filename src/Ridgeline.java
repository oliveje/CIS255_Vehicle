public class Ridgeline extends VehicleType {
    public Ridgeline(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Ridgeline");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}