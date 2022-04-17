package com.academy.service;

import com.academy.passenger.Passenger;
import com.academy.rollingStock.carriage.DiningCarriage;
import com.academy.rollingStock.carriage.passengerCarriage.ComfortLevels;
import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import com.academy.rollingStock.locomotive.EngineTypes;
import com.academy.rollingStock.locomotive.Locomotive;
import com.academy.service.passengerService.PassengerService;
import com.academy.train.passengerTrain.PassengerTrain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TrainServiceTest {
    private TrainService trainService;
    private PassengerTrain passengerTrain;
    private PassengerService passengerService;

    @Before
    public void init() {
        passengerTrain = new PassengerTrain();
        passengerTrain.addRollingStock(new Locomotive(EngineTypes.COMBUSTION_ENGINE, 1000, 100));
        passengerTrain.addRollingStock(new DiningCarriage(30, 60));
        for (int i = 0; i < 3; i++) {
            passengerTrain.addRollingStock(new PassengerCarriage(ComfortLevels.LUX, 18, 48));
            passengerTrain.addRollingStock(new PassengerCarriage(ComfortLevels.COUPE, 32, 52));
            passengerTrain.addRollingStock(new PassengerCarriage(ComfortLevels.ECONOMY, 54, 58));
        }
        passengerService = new PassengerService();
        for (int i = 0; i < 10; i++) {
            passengerService.seatReservation(new Passenger(ComfortLevels.LUX, 1), passengerTrain);
            passengerService.seatReservation(new Passenger(ComfortLevels.COUPE, 2), passengerTrain);
            passengerService.seatReservation(new Passenger(ComfortLevels.ECONOMY, 3), passengerTrain);
        }
        trainService = new TrainService();
    }

    @Test
    public void getTotalPassenger() {
        long result = trainService.getTotalPassenger(passengerService, passengerTrain);
        Assert.assertEquals(30, result);
    }

    @Test
    public void getTotalBaggage() {
        int result = trainService.getTotalBaggage(passengerService, passengerTrain);
        Assert.assertEquals(60, result);
    }

    @Test
    public void sortedCarriagesByComfortLevel() {
        PassengerTrain expected = new PassengerTrain();
        for (PassengerCarriage carriage : passengerTrain.getPassengerCarriages()) {
            if (carriage.getComfortLevel() == ComfortLevels.LUX) expected.addRollingStock(carriage);
        }
        for (PassengerCarriage carriage : passengerTrain.getPassengerCarriages()) {
            if (carriage.getComfortLevel() == ComfortLevels.COUPE) expected.addRollingStock(carriage);
        }
        for (PassengerCarriage carriage : passengerTrain.getPassengerCarriages()) {
            if (carriage.getComfortLevel() == ComfortLevels.ECONOMY) expected.addRollingStock(carriage);
        }
        trainService.sortedCarriagesByComfortLevel(passengerTrain);
        List<PassengerCarriage> result = passengerTrain.getPassengerCarriages();
        Assert.assertEquals(expected.getPassengerCarriages(), result);
    }

    @Test
    public void searchCarriagesByRangePassengers() {
        trainService.searchCarriagesByRangePassengers(3, 5, passengerService, passengerTrain);
    }
}
