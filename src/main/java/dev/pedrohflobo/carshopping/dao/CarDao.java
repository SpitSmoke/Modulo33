package dev.pedrohflobo.carshopping.dao;

import java.util.List;

import dev.pedrohflobo.carshopping.dao.generics.GenericDao;
import dev.pedrohflobo.carshopping.domain.Car;
import jakarta.persistence.EntityManager;

public class CarDao extends GenericDao<Car, Long> implements ICarDao {

  EntityManager entityManager;

  public CarDao(EntityManager entityManager) {
    super(entityManager);
    this.entityManager = entityManager;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Car> findCarsForSale() {
    return entityManager.createQuery("SELECT c FROM Car c WHERE c.inventory != NULL")
        .getResultList();
  }

}
