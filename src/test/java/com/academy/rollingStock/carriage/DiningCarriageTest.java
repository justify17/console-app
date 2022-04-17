package com.academy.rollingStock.carriage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiningCarriageTest {
    private DiningCarriage diningCarriage;

    @Before
    public void init() {
        diningCarriage = new DiningCarriage(40, 58);
    }

    @Test
    public void getQuantityOfSeats() {
        int res = diningCarriage.getQuantityOfSeats();
        Assert.assertEquals(40, res);
    }

    @Test
    public void getWeight() {
        int res = diningCarriage.getWeight();
        Assert.assertEquals(58, res);
    }
}
