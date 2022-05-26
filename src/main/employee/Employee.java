package main.employee;

import main.MyIO;

import java.util.Formatter;
import java.util.Scanner;

//Super class for driver and mechanic
public abstract class Employee implements MyIO {

    private final int eNumber;
    private final String fname;
    private final String lname;
    private final String dob;
    private final String address;
    private final int postcode;

    /**
     * Create a new employee object
     * @param eNumber The employees identifying number
     * @param fname The employees first name
     * @param lname The employees last name
     * @param dob The employees date of birth
     * @param address The employees address
     * @param postcode The employees postcode
     */
    public Employee(int eNumber, String fname, String lname, String dob, String address, int postcode){

        this.eNumber = eNumber;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;

    }

    //Returns the employees number
    public int getENumber(){

        return eNumber;
    }

    @Override
    public void readData(Scanner s) {

    }

    @Override
    public void writeData(Formatter f) {

    }

    @Override
    public String toString() {
        return "First Name: " + fname +
                "\nLast Name: " + lname +
                "\nDOB: " + dob +
                "\nAddress: " + address +
                "\nPostcode: " + postcode;
    }
}
