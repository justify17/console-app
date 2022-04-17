package com.academy.rollingStock.locomotive;

import com.academy.rollingStock.RailwayRollingStock;

public class Locomotive implements RailwayRollingStock {
    private EngineTypes engineType;
    private int traction;
    private int weight;

    public Locomotive(EngineTypes engineType, int traction, int weight) {
        this.weight = weight;
        this.traction = traction;
        this.engineType = engineType;
    }

    public EngineTypes getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineTypes engineType) {
        this.engineType = engineType;
    }

    public int getTraction() {
        return traction;
    }

    public void setTraction(int traction) {
        this.traction = traction;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getDescription() {
        return "Локомотив";
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "engineType=" + engineType +
                ", traction(tons)=" + traction +
                ", weight(tons)=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locomotive that = (Locomotive) o;

        if (traction != that.traction) return false;
        if (weight != that.weight) return false;
        return engineType == that.engineType;
    }

    @Override
    public int hashCode() {
        int result = engineType != null ? engineType.hashCode() : 0;
        result = 31 * result + traction;
        result = 31 * result + weight;
        return result;
    }
}