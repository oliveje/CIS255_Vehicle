public class Crz extends VehicleType {
    public Crz(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Crz");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
