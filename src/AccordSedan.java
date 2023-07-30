public class AccordSedan extends VehicleType {
    public AccordSedan(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Accord Sedan");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
