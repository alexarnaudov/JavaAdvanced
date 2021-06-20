public class Car {
    private String brand;
    private String model;
    private int horsePower;

    //getters
    public int getHorsePower(){
        return this.horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    //setters
    public void setBrand(String brand){this.brand = brand;}
    public void setHorsePower(int horsePower){this.horsePower = horsePower;}
    public void setModel(String model){this.model=model;}

    //constructors

    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
}
