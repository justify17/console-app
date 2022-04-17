package com.academy.rollingStock.carriage;

public class DiningCarriage extends Carriage {
    private int quantityOfSeats;

    public DiningCarriage(int quantityOfSeats, int weight) {
        super(weight);
        this.quantityOfSeats = quantityOfSeats;
    }

    public int getQuantityOfSeats() {
        return quantityOfSeats;

    }

    public void setQuantityOfSeats(int quantityOfSeats) {
        this.quantityOfSeats = quantityOfSeats;
    }

    @Override
    public String getDescription() {
        return "Вагон-ресторан";
    }

    @Override
    public String toString() {
        return "DiningCarriage{" +
                "weight(tons)=" + weight +
                ", quantityOfSeats=" + quantityOfSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiningCarriage that = (DiningCarriage) o;

        return quantityOfSeats == that.quantityOfSeats;
    }

    @Override
    public int hashCode() {
        return quantityOfSeats;
    }
}