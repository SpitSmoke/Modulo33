package dev.pedrohflobo.carshopping.services;

import dev.pedrohflobo.carshopping.dao.AcessoryDao;
import dev.pedrohflobo.carshopping.domain.Acessory;
import dev.pedrohflobo.carshopping.services.generics.GenericService;

public class AcessoryService extends GenericService<Acessory, Long, AcessoryDao> implements IAcessoryService{

  public AcessoryService(AcessoryDao dao) {
    super(dao);
  }

}
