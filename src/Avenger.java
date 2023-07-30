public class Avenger extends VehicleType {
    public Avenger(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Avenger");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}

