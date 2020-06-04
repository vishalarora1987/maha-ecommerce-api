package com.maha.ecommerce.constants;

import com.maha.ecommerce.dto.CheckoutResponse;
import com.maha.ecommerce.model.Discount;
import com.maha.ecommerce.model.Watch;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;

public class TestConstants {

  public static final String watchID1 = "001";
  public static final String watchID2 = "002";
  public static final String watchID3 = "003";

  public static final Watch watch1 = Watch.builder()
      .id(watchID1)
      .name("Rolex")
      .price(new BigDecimal(100))
      .discount(Discount.builder()
          .id("D01")
          .discountedQuantity(3)
          .discountedAmount(new BigDecimal(200))
          .build())
      .build();

  public static final Watch watch2 = Watch.builder()
      .id(watchID2)
      .name("Michael Kors")
      .price(new BigDecimal(80))
      .discount(Discount.builder()
          .id("D02")
          .discountedQuantity(2)
          .discountedAmount(new BigDecimal(120))
          .build())
      .build();

  public static final Watch watch3 = Watch.builder()
      .id(watchID3)
      .name("Swatch")
      .price(new BigDecimal(50))
      .discount(null)
      .build();

  public static final List<String> watchIdsNoDiscount = Arrays.asList("001", "002", "003", "001");
  public static final List<String> watchIdsWithDiscount = Arrays
      .asList("001", "002", "003", "001", "002");
  public static final BigDecimal watchIdsNoDiscountPRICE = new BigDecimal(330);
  public static final BigDecimal watchIdsWithDiscountPRICE = new BigDecimal(370);

  public static final ResponseEntity<CheckoutResponse> watchIdsNoDiscountResult = ResponseEntity
      .ok().body(new CheckoutResponse().builder().price(watchIdsNoDiscountPRICE).build());
  public static final CheckoutResponse watchIdsNoDiscountCatalogueServiceResponse = new CheckoutResponse()
      .builder().price(watchIdsNoDiscountPRICE).build();

  public static final ResponseEntity<CheckoutResponse> watchIdsWithDiscountResult = ResponseEntity
      .ok().body(new CheckoutResponse().builder().price(watchIdsWithDiscountPRICE).build());
  public static final CheckoutResponse watchIdsWithDiscountCatalogueServiceResponse = new CheckoutResponse()
      .builder().price(watchIdsWithDiscountPRICE).build();

}
