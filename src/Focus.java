public class Focus extends VehicleType {
    public Focus(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Focus");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
