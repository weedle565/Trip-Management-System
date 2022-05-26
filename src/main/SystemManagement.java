package main;

import main.employee.Driver;
import main.employee.Employee;
import main.employee.Mechanic;
import main.trip.Trip;
import main.trip.TripLeg;
import main.vehicle.Truck;
import main.vehicle.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;

public class SystemManagement {

    //Lists to store important information
    ArrayList<Employee> employees;
    ArrayList<Vehicle> vehicles;
    ArrayList<Trip> trips;

    public SystemManagement(){

        employees = new ArrayList<>();
        vehicles = new ArrayList<>();
        trips = new ArrayList<>();

    }

    //Load all employees from the file employees.txt
    public void initEmployees() throws FileNotFoundException {

        Scanner s = new Scanner(new File("src/employees.txt"));

        //Read file, split each line and create a new driver or mechanic dependent on the first letter of the line
        while (s.hasNextLine()) {
            String[] splitE = s.nextLine().split(",");

            //Read from the split string and put the correct values into the constructor
            switch (splitE[0]) {
                case "D" -> employees.add(new Driver(Integer.parseInt(splitE[1]), splitE[2], splitE[3], splitE[4],
                        splitE[5], Integer.parseInt(splitE[6]), Integer.parseInt(splitE[7]), splitE[8]));
                case "M" -> employees.add(new Mechanic(Integer.parseInt(splitE[1]), splitE[2], splitE[3], splitE[4],
                        splitE[5], Integer.parseInt(splitE[6]), splitE[7], splitE[8]));
            }
        }

    }

    //Load all vehicles from the file vehicles.txt
    public void initVehicles() throws FileNotFoundException {

        Scanner s = new Scanner(new File("src/vehicles.txt"));

        while (s.hasNextLine()) {

            String[] trucks = s.nextLine().split(",");

            Truck t = new Truck(trucks[1], Double.parseDouble(trucks[2]), Double.parseDouble(trucks[3]));

            vehicles.add(t);
        }
    }

    //Load all trips from the file trips.txt
    public void initTrips() throws FileNotFoundException {

        Scanner s = new Scanner(new File("src/trips.txt"));

        ArrayList<TripLeg> trips = new ArrayList<>();

        while (s.hasNextLine()){

            String[] tripSplitter = s.nextLine().split(",");

            if(tripSplitter.length == 3) {
                trips.add(new TripLeg(Integer.parseInt(tripSplitter[0]), tripSplitter[1], tripSplitter[2]));
            } else if(tripSplitter.length != 1) {
                Trip t = new Trip(Integer.parseInt(tripSplitter[0]), tripSplitter[1], tripSplitter[2], trips);
                this.trips.add(t);
                trips.clear();
            }

        }

    }

    //Read file data
    public void readData() throws FileNotFoundException {

        initTrips();
        initVehicles();
        initEmployees();

    }

    public void writeData(Formatter f){

    }

    //Display the usages of the system
    private String displayMenu(){

        return """
                Commands:\s
                1: Display employees
                2: Display vehicles
                3: Display trips
                4: Find an employee
                5: Find a vehicle
                6: Find trip of date
                7: Find trip
                8: Add trips, employees and vehicles
                0: Exit
                Enter Command:\s""";

    }

    //Handles each commands
    private void UI() {

        Scanner s = new Scanner(System.in);

        System.out.println(displayMenu());

        int input = Integer.parseInt(s.nextLine());

        while(input != 0){

            switch (input) {
                case 1 -> System.out.println(employees.iterator().next().toString());
                case 2 -> System.out.println(vehicles.iterator().next().toString());
                case 3 -> System.out.println(trips.iterator().next().toString());
                case 4 -> {
                    System.out.println("Input employee number: ");
                    int num = Integer.parseInt(s.nextLine());
                    Employee foundCustomer = employees.stream().filter(employee -> employee.getENumber() == num).findAny().orElse(null);
                    System.out.println(foundCustomer);
                }
                case 5 -> {
                    System.out.println("Input vehicle rego: ");
                    String rego = s.nextLine();
                    Vehicle foundVehicle = vehicles.stream().filter(vehicle -> vehicle.getRego().equals(rego)).findAny().orElse(null);
                    System.out.println(foundVehicle);
                }
                case 6 -> {
                    System.out.println("Input a trip date: ");
                    String date = s.nextLine();
                    Trip foundTrip = trips.stream().filter(trip -> trip.getTripDate().equals(date)).findAny().orElse(null);
                    System.out.println(foundTrip);
                }
                case 7 -> {
                    System.out.println("Input a trip number: ");
                    int tripNum = Integer.parseInt(s.nextLine());
                    trips.add(makeTrip(tripNum, s));

                    System.out.println("main.trip.Trip creation success");
                }
            }

            System.out.println(displayMenu());
            input = Integer.parseInt(s.nextLine());

        }
    }

    //Potential issue, if trip fails to be made null will be added to the list, the task was to assume user input is correct so it is kept this way however
    private Trip makeTrip(int tripNum, Scanner s){

        System.out.println("Input an employee number: ");
        int num = Integer.parseInt(s.nextLine());

        if(employees.iterator().next().getENumber() == num){
            System.out.println("main.trip.Trip creation failed");
            return null;
        }

        System.out.println("Input when the trip is: ");
        String date = s.nextLine();

        System.out.println("Input a rego: ");
        String rego = s.nextLine();

        if(Objects.equals(vehicles.iterator().next().getRego(), rego)){
            System.out.println("main.trip.Trip creation failed");
            return null;
        }

        System.out.println("Type number of trip legs: ");
        int legs = Integer.parseInt(s.nextLine());

        return new Trip(tripNum, date, rego, createTripLegs(legs, s));


    }

    //Create a new trip leg, used in makeTrip()
    private ArrayList<TripLeg> createTripLegs(int legs, Scanner s){

        ArrayList<TripLeg> tripLegs = new ArrayList<>();

        for(int i = 1; i <= legs; i++){

            System.out.println("Input leg " + i + " (departure,destination): ");

            String[] splitter = s.nextLine().split(",");

            tripLegs.add(new TripLeg(i, splitter[0], splitter[1]));

        }

        return tripLegs;
    }

    public static void main(String[] args) throws FileNotFoundException {

        SystemManagement sm = new SystemManagement();

        sm.readData();

        sm.UI();

    }
}
