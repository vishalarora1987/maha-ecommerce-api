package com.maha.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity(name = "discount")
@Data
@Builder
public class Discount implements Serializable {

  @Id
  private String id;

  @Column(name = "discounted_quantity")
  private int discountedQuantity;

  @Column(name = "discounted_amount")
  private BigDecimal discountedAmount;
}
