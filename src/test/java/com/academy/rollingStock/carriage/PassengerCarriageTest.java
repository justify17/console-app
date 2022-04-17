package com.academy.rollingStock.carriage;

import com.academy.rollingStock.carriage.passengerCarriage.ComfortLevels;
import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassengerCarriageTest {
    private PassengerCarriage carriage;

    @Before
    public void init() {
        carriage = new PassengerCarriage(ComfortLevels.LUX, 54, 60);
    }

    @Test
    public void getComfortLevel() {
        ComfortLevels result = carriage.getComfortLevel();
        Assert.assertEquals(ComfortLevels.LUX, result);
    }

    @Test
    public void getPassengerCapacity() {
        int result = carriage.getPassengerCapacity();
        Assert.assertEquals(54, result);
    }

    @Test
    public void getCarriageClass() {
        int res = carriage.getCarriageClass();
        Assert.assertEquals(1, res);
        carriage.setComfortLevel(ComfortLevels.COUPE);
        res = carriage.getCarriageClass();
        Assert.assertEquals(2, res);
        carriage.setComfortLevel(ComfortLevels.ECONOMY);
        res = carriage.getCarriageClass();
        Assert.assertEquals(3, res);
    }
}