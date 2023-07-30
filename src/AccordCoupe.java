public class AccordCoupe extends VehicleType {
    public AccordCoupe(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Accord Coupe");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
