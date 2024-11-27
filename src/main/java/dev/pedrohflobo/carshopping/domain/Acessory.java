package dev.pedrohflobo.carshopping.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tb_acessory", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "name", "fk_manufacturer" })
})
@SequenceGenerator(name = "acessory", sequenceName = "sq_tb_acessory", allocationSize = 1)
public class Acessory {

  @Id
  @GeneratedValue(generator = "acessory", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(length = 30, nullable = false)
  private String name;

  @Column(length = 255)
  private String description;

  private Integer inventory;

  @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  @JoinTable(name = "tb_acessory_car", joinColumns = @JoinColumn(name = "id_acessory", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_car", referencedColumnName = "id"))
  private List<Car> cars;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_manufacturer")
  private Manufacturer manufacturer = new Manufacturer();

  public Acessory(String name, List<Car> cars, Manufacturer manufacturer) {
    this.name = name;
    this.cars = cars;
    this.manufacturer = manufacturer;
  }

  public Acessory(String name, Car car, Manufacturer manufacturer) {
    this.name = name;
    this.cars = new ArrayList<Car>(Arrays.asList(car));
    this.manufacturer = manufacturer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public Integer getInventory() {
    return inventory;
  }

  public void setInventory(Integer inventory) {
    this.inventory = inventory;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

}
