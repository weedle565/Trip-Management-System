package main.employee;

import java.util.Formatter;
import java.util.Scanner;

public class Driver extends Employee {

    private final int license;
    private final String status;

    /**
     *
     * @param eNumber The employee number of the driver
     * @param fname The first name of the driver
     * @param lname The last name of the driver
     * @param dob The date of birth of the driver
     * @param address The address of the driver
     * @param postcode The drivers postcode
     * @param license The license number of the driver
     * @param status The availability of the driver
     */
    public Driver(int eNumber, String fname, String lname, String dob, String address, int postcode, int license, String status){

        super(eNumber, fname, lname, dob, address, postcode);
        this.license = license;
        this.status = status;

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLicense: " + license +
                "\nStatus: " + status + "\n";
    }

    @Override
    public void readData(Scanner s) {
        super.readData(s);
    }

    @Override
    public void writeData(Formatter f) {
        super.writeData(f);
    }
}
