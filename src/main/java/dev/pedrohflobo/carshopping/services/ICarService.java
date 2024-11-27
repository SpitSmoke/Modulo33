package dev.pedrohflobo.carshopping.services;

import java.util.List;

import dev.pedrohflobo.carshopping.domain.Car;

public interface ICarService {

  public List<Car> findCarsForSale();

}
