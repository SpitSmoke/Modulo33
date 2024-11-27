package dev.pedrohflobo.carshopping.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

  private static EntityManagerFactory entityManagerFactory = null;

  private JpaUtil() {

  }

  public static void createEntityManagerFactory(String name) {
    if (entityManagerFactory == null) {
      entityManagerFactory = Persistence.createEntityManagerFactory(name);
      triggerEntityManagerFactoryToClose();
    }
  }

  public static EntityManager getentityManager() {
    return entityManagerFactory.createEntityManager();
  }

  public static void closeEntityManagerFactory() {
    entityManagerFactory.close();
  }

  private static void triggerEntityManagerFactoryToClose() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        closeEntityManagerFactory();
      }
    });
  }

}
