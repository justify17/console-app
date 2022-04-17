package com.academy.rollingStock.locomotive;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocomotiveTest {
    private Locomotive locomotive;

    @Before
    public void init() {
        locomotive = new Locomotive(EngineTypes.COMBUSTION_ENGINE, 800, 100);
    }

    @Test
    public void getEngineType() {
        EngineTypes engineType = locomotive.getEngineType();
        Assert.assertEquals(EngineTypes.COMBUSTION_ENGINE, engineType);
    }

    @Test
    public void getTraction() {
        int res = locomotive.getTraction();
        Assert.assertEquals(800, res);
    }

    @Test
    public void getWeight() {
        int res = locomotive.getWeight();
        Assert.assertEquals(100, res);
    }
}
