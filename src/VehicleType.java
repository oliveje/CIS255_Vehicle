public abstract class VehicleType extends Vehicle {
    private String model;

    public VehicleType(String make, EngineType engineType, Color color, DoorCount doorCount, int year, String model) {
        super(make, engineType, color, doorCount, year);
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

}