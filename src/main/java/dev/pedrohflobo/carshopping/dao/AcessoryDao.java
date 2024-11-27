package dev.pedrohflobo.carshopping.dao;

import dev.pedrohflobo.carshopping.dao.generics.GenericDao;
import dev.pedrohflobo.carshopping.domain.Acessory;
import jakarta.persistence.EntityManager;

public class AcessoryDao extends GenericDao<Acessory, Long> implements IAcessoryDao {

  public AcessoryDao(EntityManager entityManager) {
    super(entityManager);
  }

}
