public class Tundra extends VehicleType {
    public Tundra(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Tundra");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}