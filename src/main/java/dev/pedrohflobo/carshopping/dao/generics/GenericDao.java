package dev.pedrohflobo.carshopping.dao.generics;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Consumer;

import dev.pedrohflobo.carshopping.exception.CommitException;
import dev.pedrohflobo.carshopping.exception.IdNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class GenericDao<T, K> implements IGenericDao<T, K> {

  private EntityManager entityManager;
  private Class<T> persistentClass;

  @SuppressWarnings("unchecked")
  public GenericDao(EntityManager entityManager) {
    this.entityManager = entityManager;
    this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  @Override
  public void save(T entity) throws CommitException {
    executeInsideTransaction(entityManager -> entityManager.persist(entity));
  }

  @Override
  public void update(T entity) throws CommitException {
    executeInsideTransaction(entityManager -> entityManager.merge(entity));
  }

  @Override
  public T findById(K id) throws IdNotFoundException {
    return entityManager.find(persistentClass, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<T> findAll() {
    return entityManager.createQuery("SELECT c FROM " + persistentClass.getSimpleName() + " c").getResultList();
  }

  @Override
  public void deleteById(K id) throws IdNotFoundException, CommitException {
    T entity = findById(id);
    if (entity == null) {
      throw new IdNotFoundException();
    }
    executeInsideTransaction(entityManager -> entityManager.remove(entity));
  }

  private void executeInsideTransaction(Consumer<EntityManager> action) throws CommitException {
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin();
      action.accept(entityManager);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
      entityManager.close();
      throw new CommitException();
    }

  }

}
