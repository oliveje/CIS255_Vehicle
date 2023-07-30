public class Insight extends VehicleType {
    public Insight(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Insight");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
