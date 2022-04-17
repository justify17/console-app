package com.academy.service.passengerService;

import com.academy.passenger.Passenger;
import com.academy.rollingStock.carriage.passengerCarriage.ComfortLevels;
import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import com.academy.rollingStock.locomotive.EngineTypes;
import com.academy.rollingStock.locomotive.Locomotive;
import com.academy.train.passengerTrain.PassengerTrain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassengerServiceTest {
    private PassengerService passengerService;
    private Passenger passenger;
    private PassengerTrain train;

    @Before
    public void init() {
        passengerService = new PassengerService();
        passenger = new Passenger(ComfortLevels.LUX, 2);
        train = new PassengerTrain();
        train.addRollingStock(new Locomotive(EngineTypes.COMBUSTION_ENGINE, 1000, 100));
        train.addRollingStock(new PassengerCarriage(ComfortLevels.LUX, 18, 48));
        train.addRollingStock(new PassengerCarriage(ComfortLevels.COUPE, 32, 52));
    }

    @Test
    public void seatReservation() {
        passengerService.seatReservation(passenger, train);
        Passenger resultPassenger = passengerService.getStorage().get(0).getPassenger();
        PassengerTrain resultTrain = passengerService.getStorage().get(0).getTrain();
        Assert.assertEquals(passenger, resultPassenger);
        Assert.assertEquals(train, resultTrain);
    }
}