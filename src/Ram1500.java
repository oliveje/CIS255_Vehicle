public class Ram1500 extends VehicleType {
    public Ram1500(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Ram 1500");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}