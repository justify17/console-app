package com.academy.train;

import com.academy.rollingStock.RailwayRollingStock;

public interface RailwayTransport {
    void addRollingStock(RailwayRollingStock rollingStock);

    void removeRollingStock(RailwayRollingStock rollingStock);
}