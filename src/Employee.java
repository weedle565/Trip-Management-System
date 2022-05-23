import java.util.Formatter;
import java.util.Scanner;

public abstract class Employee implements MyIO{

    private int eNumber;
    private String fname;
    private String lname;
    private String dob;
    private String address;
    private int postcode;

    public Employee(){

    }

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
        return "";
    }
}
