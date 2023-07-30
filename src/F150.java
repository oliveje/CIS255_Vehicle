public class F150 extends VehicleType {
    public F150(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "F150");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
