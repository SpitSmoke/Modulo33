package dev.pedrohflobo.carshopping.dao;

import dev.pedrohflobo.carshopping.dao.generics.GenericDao;
import dev.pedrohflobo.carshopping.domain.Manufacturer;
import jakarta.persistence.EntityManager;

public class ManufacturerDao extends GenericDao<Manufacturer, Long> implements IManufacturerDao {

  public ManufacturerDao(EntityManager entityManager) {
    super(entityManager);
  }

}
