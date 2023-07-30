public class Yaris extends VehicleType {
    public Yaris(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Yaris");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}