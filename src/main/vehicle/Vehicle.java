package main.vehicle;

import main.MyIO;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Superclass for main.vehicle.Truck
 */
public abstract class Vehicle implements MyIO {

    private final String rego;

    /**
     * Creates a new vehicle
     * @param rego Vehicles registration
     */
    public Vehicle(String rego){

        this.rego = rego;

    }

    public String getRego(){
        return rego;
    }

    @Override
    public void readData(Scanner s) {

    }

    @Override
    public void writeData(Formatter f) {

    }

    @Override
    public String toString() {
        return "Rego: " + rego;
    }
}
