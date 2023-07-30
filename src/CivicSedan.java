public class CivicSedan extends VehicleType {
    public CivicSedan(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Civic Sedan");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
