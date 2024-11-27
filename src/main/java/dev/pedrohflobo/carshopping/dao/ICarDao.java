package dev.pedrohflobo.carshopping.dao;

import java.util.List;

import dev.pedrohflobo.carshopping.dao.generics.IGenericDao;
import dev.pedrohflobo.carshopping.domain.Car;

public interface ICarDao extends IGenericDao<Car, Long> {

  List<Car> findCarsForSale();

}
