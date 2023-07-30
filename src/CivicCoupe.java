public class CivicCoupe extends VehicleType {
    public CivicCoupe(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Civic Coupe");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
