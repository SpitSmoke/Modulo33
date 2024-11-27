package dev.pedrohflobo.carshopping.services;

import java.util.List;

import dev.pedrohflobo.carshopping.dao.CarDao;
import dev.pedrohflobo.carshopping.domain.Car;
import dev.pedrohflobo.carshopping.services.generics.GenericService;

public class CarService extends GenericService<Car, Long, CarDao> implements ICarService {

  CarDao carDao;
  public CarService(CarDao dao) {
    super(dao);
    carDao = dao;
  }

  @Override
  public List<Car> findCarsForSale() {
    return carDao.findCarsForSale();
  }
 
}
