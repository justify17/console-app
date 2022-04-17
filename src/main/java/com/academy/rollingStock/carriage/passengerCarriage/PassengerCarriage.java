package com.academy.rollingStock.carriage.passengerCarriage;

import com.academy.rollingStock.carriage.Carriage;

public class PassengerCarriage extends Carriage {
    private ComfortLevels comfortLevel;
    private int passengerCapacity;
    private static int carriageCounter;
    private int carriageNumber;

    public PassengerCarriage(ComfortLevels comfortLevel, int passengerCapacity, int weight) {
        super(weight);
        this.comfortLevel = comfortLevel;
        this.passengerCapacity = passengerCapacity;
        carriageNumber = ++carriageCounter;
    }

    @Override
    public String getDescription() {
        return "Пассажирский вагон № " + carriageNumber;
    }

    public ComfortLevels getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(ComfortLevels comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public int getCarriageClass() {
        if (comfortLevel == ComfortLevels.LUX) {
            return 1;
        }
        if (comfortLevel == ComfortLevels.COUPE) {
            return 2;
        }
        if (comfortLevel == ComfortLevels.ECONOMY) {
            return 3;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "PassengerCarriage{" +
                "weight=" + weight +
                ", comfortLevel=" + comfortLevel +
                ", passengerCapacity=" + passengerCapacity +
                ", carriageNumber=" + carriageNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerCarriage that = (PassengerCarriage) o;

        if (passengerCapacity != that.passengerCapacity) return false;
        if (carriageNumber != that.carriageNumber) return false;
        return comfortLevel == that.comfortLevel;
    }

    @Override
    public int hashCode() {
        int result = comfortLevel.hashCode();
        result = 31 * result + passengerCapacity;
        result = 31 * result + carriageNumber;
        return result;
    }
}