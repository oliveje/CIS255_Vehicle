public abstract class Vehicle {
    private String make;
    private EngineType engineType;
    private Color color;
    private DoorCount doorCount;
    private int year;

    public Vehicle(String make, EngineType engineType, Color color, DoorCount doorCount, int year) {
        this.make = make;
        this.engineType = engineType;
        this.color = color;
        this.doorCount = doorCount;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Color getColor() {
        return color;
    }

    public DoorCount getDoorCount() {
        return doorCount;
    }

    public int getYear() {
        return year;
    }

    public abstract String getModel();
    public abstract String getType();

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", type='" + getType() + '\'' +
                ", model='" + getModel() + '\'' +
                ", engineType=" + engineType +
                ", color=" + color +
                ", doorCount=" + doorCount +
                ", year=" + year +
                '}';
    }
}
