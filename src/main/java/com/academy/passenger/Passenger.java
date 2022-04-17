package com.academy.passenger;

import com.academy.rollingStock.carriage.passengerCarriage.ComfortLevels;

public class Passenger {
    private final ComfortLevels comfort;
    private int baggage;

    public Passenger(ComfortLevels comfort, int baggage) {
        this.comfort = comfort;
        this.baggage = baggage;
    }

    public ComfortLevels getComfort() {
        return comfort;
    }

    public int getBaggage() {
        return baggage;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "comfort=" + comfort +
                ", baggage=" + baggage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (baggage != passenger.baggage) return false;
        return comfort == passenger.comfort;
    }

    @Override
    public int hashCode() {
        int result = comfort != null ? comfort.hashCode() : 0;
        result = 31 * result + baggage;
        return result;
    }
}