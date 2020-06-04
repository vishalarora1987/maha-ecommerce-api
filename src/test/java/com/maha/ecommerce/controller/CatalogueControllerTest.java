package com.maha.ecommerce.controller;

import static org.mockito.Mockito.when;
import com.maha.ecommerce.constants.TestConstants;
import com.maha.ecommerce.dto.CheckoutResponse;
import com.maha.ecommerce.service.CatalogueService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class CatalogueControllerTest {

  @InjectMocks
  private CatalogueController catalogueController;

  @Mock
  private CatalogueService catalogueService;

  @Test
  public void checkoutSuccess_NoDiscount() {
    when(catalogueService.checkout(TestConstants.watchIdsNoDiscount))
        .thenReturn(TestConstants.watchIdsNoDiscountCatalogueServiceResponse);

    ResponseEntity<CheckoutResponse> response = catalogueController
        .checkout(TestConstants.watchIdsNoDiscount);

    Assert.assertEquals(response, TestConstants.watchIdsNoDiscountResult);
  }

  @Test
  public void checkoutSuccess_WithDiscount() {
    when(catalogueService.checkout(TestConstants.watchIdsWithDiscount))
        .thenReturn(TestConstants.watchIdsWithDiscountCatalogueServiceResponse);

    ResponseEntity<CheckoutResponse> response = catalogueController
        .checkout(TestConstants.watchIdsWithDiscount);

    Assert.assertEquals(response, TestConstants.watchIdsWithDiscountResult);
  }
}