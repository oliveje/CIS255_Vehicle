public class Ram2500 extends VehicleType {
    public Ram2500(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Ram2500");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}