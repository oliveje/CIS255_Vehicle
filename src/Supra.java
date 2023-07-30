public class Supra extends VehicleType {
    public Supra(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Supra");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}