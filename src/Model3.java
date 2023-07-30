public class Model3 extends VehicleType {
    public Model3(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Model 3");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
