package main.employee;

import main.employee.Employee;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Subclass of employee
 */
public class Mechanic extends Employee {

    private final String qualnum;
    private final String experience;

    /**
     *
     * @param eNumber The employee number of the main.employee.Mechanic
     * @param fname The first name of the main.employee.Mechanic
     * @param lname The last name of the main.employee.Mechanic
     * @param dob The date of birth of the main.employee.Mechanic
     * @param address The address of the main.employee.Mechanic
     * @param postcode The Mechanics postcode
     * @param qualnum The mechanics qualification number
     * @param experience The mechanics experience
     */
    public Mechanic(int eNumber, String fname, String lname, String dob, String address, int postcode, String qualnum, String experience){

        super(eNumber, fname, lname, dob, address, postcode);

        this.qualnum = qualnum;
        this.experience = experience;

    }

    @Override
    public String toString() {

        return super.toString() +
                "\nQualnum: " + qualnum +
                "\nExperience: " + experience + "\n";
    }

    @Override
    public void writeData(Formatter f) {
        super.writeData(f);
    }

    @Override
    public void readData(Scanner s) {
        super.readData(s);
    }
}
