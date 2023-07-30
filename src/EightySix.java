public class EightySix extends VehicleType {
    public EightySix(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Eighty Six");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
