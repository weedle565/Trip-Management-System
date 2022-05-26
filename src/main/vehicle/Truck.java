package main.vehicle;

import java.util.Formatter;
import java.util.Scanner;

//Subclass of vehicle
public class Truck extends Vehicle {

    private final double capacity;
    private final double weight;

    /**
     * Creates a new truck object
     * @param rego Trucks registration number
     * @param capacity Maximum capacity for truck
     * @param weight Weigh of truck
     */
    public Truck(String rego, double capacity, double weight){

        super(rego);
        this.capacity = capacity;
        this.weight = weight;

    }

    @Override
    public void readData(Scanner s) {
        super.readData(s);
    }

    @Override
    public void writeData(Formatter f) {
        super.writeData(f);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCapacity: " + capacity +
                "\nWeight: " + weight + "\n";
    }
}
