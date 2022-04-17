package com.academy.service;

import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import com.academy.service.passengerService.PassengerService;
import com.academy.train.passengerTrain.PassengerTrain;

import java.util.stream.Collectors;

public class TrainService {
    public long getTotalPassenger(PassengerService passengerService, PassengerTrain passengerTrain) {
        return passengerService.getStorage().stream()
                .filter(ticket -> ticket.getTrain().equals(passengerTrain))
                .count();
    }

    public int getTotalBaggage(PassengerService passengerService, PassengerTrain passengerTrain) {
        return passengerService.getStorage().stream()
                .filter(ticket -> ticket.getTrain().equals(passengerTrain))
                .reduce(0, ((ticket, ticket2) -> ticket + ticket2.getPassenger().getBaggage()),
                        Integer::sum);
    }

    public void sortedCarriagesByComfortLevel(PassengerTrain passengerTrain) {
        passengerTrain.setTrain(passengerTrain.getTrain().stream()
                .sorted((o1, o2) -> {
                    if (o1 instanceof PassengerCarriage && o2 instanceof PassengerCarriage) {
                        return ((PassengerCarriage) o1).getCarriageClass() - (((PassengerCarriage) o2).getCarriageClass());
                    }
                    return 0;
                })
                .collect(Collectors.toList()));
    }

    public void searchCarriagesByRangePassengers(int min, int max, PassengerService passengerService, PassengerTrain passengerTrain) {
        for (PassengerCarriage passengerCarriage : passengerTrain.getPassengerCarriages()) {
            long result = passengerService.getStorage().stream()
                    .filter(ticket -> ticket.getCarriageNumber() == passengerCarriage.getCarriageNumber())
                    .count();
            if (result >= min && result <= max) {
                System.out.println("Вагон № " + passengerCarriage.getCarriageNumber() + ", число зарегистрированных" +
                        " пассажиров: " + result);
            }
        }
    }

    @Override
    public String toString() {
        return "TrainService{}";
    }
}
