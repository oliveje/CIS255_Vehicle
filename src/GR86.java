public class GR86 extends VehicleType {
    public GR86(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "GR86");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
