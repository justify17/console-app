package com.academy.train;

import com.academy.rollingStock.RailwayRollingStock;
import com.academy.rollingStock.carriage.passengerCarriage.ComfortLevels;
import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import com.academy.rollingStock.locomotive.EngineTypes;
import com.academy.rollingStock.locomotive.Locomotive;
import com.academy.train.passengerTrain.PassengerTrain;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PassengerTrainTest {
    private PassengerTrain train;

    @Before
    public void init() {
        train = new PassengerTrain();
    }

    @Test
    public void addRollingStock() {
        Locomotive locomotive = new Locomotive(EngineTypes.COMBUSTION_ENGINE, 1000, 100);
        PassengerCarriage carriage = new PassengerCarriage(ComfortLevels.LUX, 18, 48);
        train.addRollingStock(locomotive);
        train.addRollingStock(carriage);
        assertThat(train.getTrain(), hasItems(locomotive, carriage));
    }

    @Test
    public void removeRollingStock() {
        Locomotive locomotive = new Locomotive(EngineTypes.COMBUSTION_ENGINE, 1000, 100);
        PassengerCarriage carriage = new PassengerCarriage(ComfortLevels.LUX, 18, 48);
        train.addRollingStock(locomotive);
        train.addRollingStock(carriage);
        train.removeRollingStock(carriage);
        List<RailwayRollingStock> expected = List.of(locomotive);
        List<RailwayRollingStock> result = train.getTrain();
        assertThat(expected, is(result));
    }
}
