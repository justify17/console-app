package com.academy.passenger;

import com.academy.rollingStock.carriage.passengerCarriage.ComfortLevels;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassengerTest {
    private Passenger passenger;

    @Before
    public void init() {
        passenger = new Passenger(ComfortLevels.LUX, 2);
    }

    @Test
    public void getComfort() {
        ComfortLevels result = passenger.getComfort();
        Assert.assertEquals(ComfortLevels.LUX, result);
    }

    @Test
    public void getBaggage() {
        int result = passenger.getBaggage();
        Assert.assertEquals(2, result);
    }

    @Test
    public void setBaggage() {
        passenger.setBaggage(1);
        int result = passenger.getBaggage();
        Assert.assertEquals(1, result);
    }
}
