public class F250 extends VehicleType {
    public F250(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "F250");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
