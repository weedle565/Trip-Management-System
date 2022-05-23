import java.util.Formatter;
import java.util.Scanner;

public class Mechanic extends Employee {

    private String qualnum;
    private String experience;

    public Mechanic(){

    }

    @Override
    public String toString() {
        return "";
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
