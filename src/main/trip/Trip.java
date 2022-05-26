package main.trip;

import main.MyIO;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Trip implements MyIO {

    private int tripNumber;
    private String tripDate;
    private String rego;
    private ArrayList<TripLeg> tripLegs;

    /**
     *
     * @param tripNumber The identification number that is assigned to that specific trip
     * @param tripDate When the trip is
     * @param rego The registration number of the vehicle the trip uses
     * @param legs The trip legs
     */
    public Trip(int tripNumber, String tripDate, String rego, ArrayList<TripLeg> legs) {
        this.setTripNumber(tripNumber);
        this.setTripDate(tripDate);
        this.setRego(rego);
        setTripLegs(legs);
    }

    @Override
    public String toString(){

        return "main.trip.Trip number: " + getTripNumber() +
                "\nmain.trip.Trip date: " + getTripDate() +
                "\nLegs: " + getTripLegs().toString().replace("[", "").replace("]", "").replace(",", "") +
                "\nRego: " + getRego() + "\n";
    }

    @Override
    public void readData(Scanner s) {

    }

    @Override
    public void writeData(Formatter f) {

    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getRego() {
        return rego;
    }

    public void setRego(String rego) {
        this.rego = rego;
    }

    public ArrayList<TripLeg> getTripLegs() {
        return tripLegs;
    }

    public void setTripLegs(ArrayList<TripLeg> tripLegs) {
        this.tripLegs = tripLegs;
    }
}
