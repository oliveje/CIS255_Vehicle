public class Challenger extends VehicleType {
    public Challenger(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Challenger");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
