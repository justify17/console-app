package com.academy.train.passengerTrain;

import com.academy.rollingStock.RailwayRollingStock;
import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import com.academy.rollingStock.locomotive.Locomotive;
import com.academy.train.RailwayTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PassengerTrain implements RailwayTransport {
    private List<RailwayRollingStock> train = new ArrayList<>();

    @Override
    public void addRollingStock(RailwayRollingStock rollingStock) {
        train.add(rollingStock);
    }

    @Override
    public void removeRollingStock(RailwayRollingStock rollingStock) {
        train.remove(rollingStock);
    }

    public List<RailwayRollingStock> getTrain() {
        return train;
    }

    public void setTrain(List<RailwayRollingStock> train) {
        this.train = train;
    }

    public List<Locomotive> getLocomotives() {
        return train.stream()
                .filter(railwayRollingStock -> railwayRollingStock instanceof Locomotive)
                .map(railwayRollingStock -> (Locomotive) railwayRollingStock)
                .collect(Collectors.toList());
    }

    public List<PassengerCarriage> getPassengerCarriages() {
        return train.stream()
                .filter(railwayRollingStock -> railwayRollingStock instanceof PassengerCarriage)
                .map(railwayRollingStock -> (PassengerCarriage) railwayRollingStock)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "PassengerTrain{" +
                "com.academy.train=" + train +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerTrain that = (PassengerTrain) o;

        return train.equals(that.train);
    }

    @Override
    public int hashCode() {
        return train.hashCode();
    }
}