import java.util.Formatter;
import java.util.Scanner;

public abstract class Vehicle implements MyIO {

    private String rego;

    public Vehicle(){

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
        return "";
    }
}
