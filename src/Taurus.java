public class Taurus extends VehicleType {
    public Taurus(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Taurus");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}