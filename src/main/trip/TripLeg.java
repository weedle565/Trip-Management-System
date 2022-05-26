package main.trip;

import java.util.Formatter;
import java.util.Scanner;

public record TripLeg(int legNumber, String departure, String destination) {

    @Override
    public String toString() {

        return "\nLeg number: " + legNumber +
                "\nDeparture: " + departure +
                "\nDestination: " + destination + "\n";
    }

}
