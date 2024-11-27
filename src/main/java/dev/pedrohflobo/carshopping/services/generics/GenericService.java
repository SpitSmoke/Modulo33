package dev.pedrohflobo.carshopping.services.generics;

import java.util.List;

import dev.pedrohflobo.carshopping.dao.generics.GenericDao;
import dev.pedrohflobo.carshopping.exception.CommitException;
import dev.pedrohflobo.carshopping.exception.IdNotFoundException;
import dev.pedrohflobo.carshopping.utils.JpaUtil;

public class GenericService<T, K, D extends GenericDao<T, K>> implements IGenericService<T, K, D> {

  private GenericDao<T, K> dao;

  public GenericService(D dao) {
    JpaUtil.createEntityManagerFactory("default");
    this.dao = dao;
  }

  @Override
  public void register(T entity) throws CommitException {
    dao.save(entity); 
  }

  @Override
  public List<T> getAll() {
    return dao.findAll();
  }

  @Override
  public void update(T entity) throws CommitException{
    dao.update(entity);
  }

  @Override
  public void deleteById(K id) throws IdNotFoundException, CommitException{
    dao.deleteById(id);
  }

  @Override
  public T findById(K id) throws IdNotFoundException {
    return dao.findById(id);  
  }

}
