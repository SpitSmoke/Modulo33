package dev.pedrohflobo.carshopping.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tb_car", uniqueConstraints={
  @UniqueConstraint(columnNames = {"model", "manufactureYear", "fk_manufacturer"})
  }
)
@SequenceGenerator(name = "car", sequenceName = "sq_tb_car", allocationSize = 1)
public class Car {

  @Id
  @GeneratedValue(generator = "car", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(length = 30, nullable = false)
  private String model;

  @Column(length = 4, nullable = false)
  private Integer manufactureYear;

  @ManyToMany(mappedBy = "cars", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
  private List<Acessory> acessories = new ArrayList<Acessory>();

  private Integer inventory;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_manufacturer")
  private Manufacturer manufacturer = new Manufacturer();

  public Car() {
  }
 
  public Car(String model, Integer manufactureYear, Manufacturer manufacturer) {
    this.model = model;
    this.manufactureYear = manufactureYear;
    this.manufacturer = manufacturer;
  }
  
  public void addAcessory(Acessory acessory){
    this.acessories.add(acessory);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getManufactureYear() {
    return manufactureYear;
  }

  public void setManufactureYear(Integer manufactureYear) {
    this.manufactureYear = manufactureYear;
  }

  public List<Acessory> getAcessories() {
    return acessories;
  }

  public void setAcessories(List<Acessory> acessories) {
    this.acessories = acessories;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Integer getInventory() {
    return inventory;
  }

  public void setInventory(Integer inventory) {
    this.inventory = inventory;
  }

}
