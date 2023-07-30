public class Dart extends VehicleType {
    public Dart(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Dart");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
