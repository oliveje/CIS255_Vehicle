public class Corolla extends VehicleType {
    public Corolla(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Corolla");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
