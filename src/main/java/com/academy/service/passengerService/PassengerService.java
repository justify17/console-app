package com.academy.service.passengerService;

import com.academy.passenger.Passenger;
import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import com.academy.train.passengerTrain.PassengerTrain;

import java.util.ArrayList;
import java.util.List;

public class PassengerService {
    private List<Ticket> storage = new ArrayList<>();

    public void seatReservation(Passenger passenger, PassengerTrain train) {
        Ticket ticket = ticketGeneration(passenger, train);
        if (ticket != null) {
            storage.add(ticket);
        } else {
            System.out.println("Все места на данный поезд забронированы.");
        }
    }

    private Ticket ticketGeneration(Passenger passenger, PassengerTrain train) {
        List<Ticket> availableTickets = new ArrayList<>();
        for (PassengerCarriage carriage : train.getPassengerCarriages()) {
            if (passenger.getComfort() == carriage.getComfortLevel()) {
                for (int i = 1; i <= carriage.getPassengerCapacity(); i++) {
                    if (storage.size() == 0) {
                        availableTickets.add(new Ticket(passenger, train, carriage.getCarriageNumber(), i));
                        continue;
                    }
                    boolean check = true;
                    Ticket checkedTicket = null;
                    for (Ticket ticket : storage) {
                        if (ticket.getTrain().equals(train) && ticket.getCarriageNumber() == carriage.getCarriageNumber()
                                && ticket.getSeatNumber() == i) {
                            check = false;
                            break;
                        }
                        checkedTicket = new Ticket(passenger, train, carriage.getCarriageNumber(), i);
                    }
                    if (check) {
                        availableTickets.add(checkedTicket);
                    }
                }
            }
        }
        return availableTickets.isEmpty() ? null : availableTickets.get((int) (Math.random() * availableTickets.size()));
    }

    public List<Ticket> getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return "PassengerService{" +
                "storage=" + storage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerService that = (PassengerService) o;

        return storage.equals(that.storage);
    }

    @Override
    public int hashCode() {
        return storage.hashCode();
    }
}
