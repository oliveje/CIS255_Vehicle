public class Fusion extends VehicleType {
    public Fusion(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Fusion");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
