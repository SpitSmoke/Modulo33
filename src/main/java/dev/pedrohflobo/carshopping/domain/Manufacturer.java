package dev.pedrohflobo.carshopping.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_manufacturer")
@SequenceGenerator(name = "manufacturer", sequenceName = "sq_tb_manufacturer", allocationSize = 1)
public class Manufacturer {

  @Id
  @GeneratedValue(generator = "manufacturer", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(length = 20, nullable = false)
  private String name;

  @Column(length = 20)
  private String manufacturingSite;

  public Manufacturer() {

  }

  public Manufacturer(String name) {
    this.name = name;
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

  public String getManufacturingSite() {
    return manufacturingSite;
  }

  public void setManufacturingSite(String manufacturingSite) {
    this.manufacturingSite = manufacturingSite;
  }

}
