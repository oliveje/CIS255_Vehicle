public class Mustang extends VehicleType {
    public Mustang(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        super(make, engineType, color, doorCount, year, "Mustang");
    }

    @Override
    public String getType() {
        return "Coupe";
    }
}
