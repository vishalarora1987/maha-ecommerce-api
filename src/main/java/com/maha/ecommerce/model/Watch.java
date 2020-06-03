package com.maha.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity(name = "watches")
@Data
public class Watch implements Serializable {

  @Id
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "unit_price")
  private BigDecimal price;

  @OneToOne
  private Discount discount;
}
