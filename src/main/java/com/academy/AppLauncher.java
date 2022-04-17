package com.academy;

import com.academy.passenger.Passenger;
import com.academy.rollingStock.carriage.DiningCarriage;
import com.academy.rollingStock.carriage.passengerCarriage.ComfortLevels;
import com.academy.rollingStock.carriage.passengerCarriage.PassengerCarriage;
import com.academy.rollingStock.locomotive.EngineTypes;
import com.academy.rollingStock.locomotive.Locomotive;
import com.academy.service.TrainService;
import com.academy.service.passengerService.PassengerService;
import com.academy.train.passengerTrain.PassengerTrain;

/**
 * Task 1
 * Создать консольное приложение:
 * № 8. Транспорт:
 * Определить иерархию подвижного состава железнодорожного транспорта. Создать пассажирский поезд.
 * Посчитать общую численность пассажиров и багажа. Провести сортировку вагонов поезда на основе уровня комфортности.
 * Найти вагоны в поезде, соответствующие заданному диапазону параметров числа пассажиров.
 * Приложение должно соответствовать следующим требованиям:
 * 1. Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
 * 2. Каждый класс должен иметь исчерпывающее смысл название и информативный состав.
 * 3. При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * 4. Классы должны быть грамотно разложены по пакетам.
 * 5. Для демонстрации работы приложения использовать unit тесты.
 */

public class AppLauncher {
    public static void main(String[] args) {
        PassengerTrain passengerTrain = new PassengerTrain();
        passengerTrain.addRollingStock(new Locomotive(EngineTypes.COMBUSTION_ENGINE, 1000, 100));
        passengerTrain.addRollingStock(new DiningCarriage(30, 60));
        for (int i = 0; i < 3; i++) {
            passengerTrain.addRollingStock(new PassengerCarriage(ComfortLevels.LUX, 18, 48));
            passengerTrain.addRollingStock(new PassengerCarriage(ComfortLevels.COUPE, 32, 52));
            passengerTrain.addRollingStock(new PassengerCarriage(ComfortLevels.ECONOMY, 54, 58));
        }
        PassengerService passengerService = new PassengerService();
        for (int i = 0; i < 10; i++) {
            passengerService.seatReservation(new Passenger(ComfortLevels.LUX, 1), passengerTrain);
            passengerService.seatReservation(new Passenger(ComfortLevels.COUPE, 2), passengerTrain);
            passengerService.seatReservation(new Passenger(ComfortLevels.ECONOMY, 3), passengerTrain);
        }
        TrainService trainService = new TrainService();
        System.out.println(trainService.getTotalPassenger(passengerService, passengerTrain));
        System.out.println(trainService.getTotalBaggage(passengerService, passengerTrain));
        trainService.sortedCarriagesByComfortLevel(passengerTrain);
        trainService.searchCarriagesByRangePassengers(3, 5, passengerService, passengerTrain);
    }
}