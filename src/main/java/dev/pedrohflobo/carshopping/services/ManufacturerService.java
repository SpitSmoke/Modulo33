package dev.pedrohflobo.carshopping.services;

import dev.pedrohflobo.carshopping.dao.ManufacturerDao;
import dev.pedrohflobo.carshopping.domain.Manufacturer;
import dev.pedrohflobo.carshopping.services.generics.GenericService;

public class ManufacturerService extends GenericService<Manufacturer, Long, ManufacturerDao>
    implements IManufacturerService {

  public ManufacturerService(ManufacturerDao dao) {
    super(dao);
  }

}
