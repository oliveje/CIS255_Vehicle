public class Maverick extends VehicleType {
    public Maverick(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Maverick");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
