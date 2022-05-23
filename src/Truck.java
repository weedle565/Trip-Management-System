import java.util.Formatter;
import java.util.Scanner;

public class Truck extends Vehicle{

    private double capacity;
    private double weight;

    public Truck(){

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
        return "";
    }
}
