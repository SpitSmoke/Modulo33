package dev.pedrohflobo.carshopping;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import dev.pedrohflobo.carshopping.dao.AcessoryDao;
import dev.pedrohflobo.carshopping.dao.CarDao;
import dev.pedrohflobo.carshopping.domain.Acessory;
import dev.pedrohflobo.carshopping.domain.Car;
import dev.pedrohflobo.carshopping.domain.Manufacturer;
import dev.pedrohflobo.carshopping.exception.CommitException;
import dev.pedrohflobo.carshopping.exception.IdNotFoundException;
import dev.pedrohflobo.carshopping.services.AcessoryService;
import dev.pedrohflobo.carshopping.services.CarService;
import dev.pedrohflobo.carshopping.utils.JpaUtil;
import jakarta.persistence.EntityManager;

public class CarshoppingApplication {

  public static void main(String[] args) throws CommitException, IdNotFoundException {
    JpaUtil.createEntityManagerFactory("default");
    EntityManager entityManager = JpaUtil.getentityManager();

    Car car = new Car("DS", 1955, new Manufacturer("Citroen"));
    car.setInventory(0);

    Car car1 = new Car("Ka", 2010, new Manufacturer("Ford"));
    car1.setInventory(34);
    car1.addAcessory(new Acessory("Lampada Neon", car, new Manufacturer("Philips")));

    Car car2 = new Car("Celta", 2005, new Manufacturer("Chevrolet"));
    car2.setInventory(12);

    CarService carService = new CarService(new CarDao(entityManager));
    carService.register(car);
    carService.register(car1);
    carService.register(car2);

    List<Car> carList = new ArrayList<Car>(Arrays.asList(
        new Car("Vectra", 2008, new Manufacturer("Chevrolet")),
        new Car("Uno", 2018, new Manufacturer("Fiat")),
        new Car("C4", 2018, new Manufacturer("Citroen")),
        new Car("C3", 2018, new Manufacturer("Citroen")),
        new Car("HB20", 2000, new Manufacturer("Hyundai"))));

    Acessory acessory = new Acessory("Dvd", carList, new Manufacturer("Pionner"));
    AcessoryService acessoryService = new AcessoryService(new AcessoryDao(entityManager));
    acessoryService.register(acessory);

    List<Car> c = carService.findCarsForSale();
    System.out.println("\nAvailable cars to sell:");
    PrintStream p = Objects.requireNonNull(System.out);
    c.forEach(o -> p.println(o.getModel()));

    entityManager.close();

  }

}
