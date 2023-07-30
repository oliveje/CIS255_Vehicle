public class ModelS extends VehicleType {
    public ModelS(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Model S");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
