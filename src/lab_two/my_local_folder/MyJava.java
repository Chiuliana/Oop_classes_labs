package lab_two.my_local_folder;

// Main.java
public class MyJava {
    public static void main(String[] args) {
        // Creating a new Car object
        Car myCar = new Car("Toyota", "Camry", 2022);

        // Displaying initial car information
        myCar.displayCarInfo();

        // Starting the engine
        myCar.startEngine();

        // Displaying updated car information
        myCar.displayCarInfo();

        // Stopping the engine
        myCar.stopEngine();

        // Displaying final car information
        myCar.displayCarInfo();
    }

    // Car class
    static class Car {
        // Attributes
        private String brand;
        private String model;
        private int year;
        private boolean engineStarted;

        // Constructor
        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.engineStarted = false;
        }

        // Methods
        public void startEngine() {
            if (!engineStarted) {
                System.out.println("Starting the engine...");
                engineStarted = true;
            } else {
                System.out.println("The engine is already running.");
            }
        }

        public void stopEngine() {
            if (engineStarted) {
                System.out.println("Stopping the engine...");
                engineStarted = false;
            } else {
                System.out.println("The engine is already stopped.");
            }
        }

        public void displayCarInfo() {
            System.out.println("Car Information:");
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println("Engine status: " + (engineStarted ? "Running" : "Stopped"));
        }
    }
}
