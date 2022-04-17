package com.academy.service.passengerService;

import com.academy.passenger.Passenger;
import com.academy.train.passengerTrain.PassengerTrain;

public class Ticket {
    private Passenger passenger;
    private PassengerTrain train;
    private int carriageNumber;
    private int seatNumber;

    public Ticket(Passenger passenger, PassengerTrain train, int carriageNumber, int seatNumber) {
        this.passenger = passenger;
        this.train = train;
        this.carriageNumber = carriageNumber;
        this.seatNumber = seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public PassengerTrain getTrain() {
        return train;
    }

    public void setTrain(PassengerTrain train) {
        this.train = train;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "com.academy.passenger=" + passenger +
                ", com.academy.train №" + Math.abs(train.hashCode()) +
                ", carriageNumber=" + carriageNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (!passenger.equals(ticket.passenger)) return false;
        return train.equals(ticket.train);
    }

    @Override
    public int hashCode() {
        int result = passenger.hashCode();
        result = 31 * result + train.hashCode();
        return result;
    }
}