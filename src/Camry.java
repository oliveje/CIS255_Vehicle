public class Camry extends VehicleType {
    public Camry(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Camry");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
