public class Charger extends VehicleType {
    public Charger(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Charger");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
