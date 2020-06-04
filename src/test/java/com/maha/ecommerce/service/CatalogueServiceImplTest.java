package com.maha.ecommerce.service;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import com.maha.ecommerce.constants.TestConstants;
import com.maha.ecommerce.dto.CheckoutResponse;
import com.maha.ecommerce.repository.WatchRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatalogueServiceImplTest {

  @InjectMocks
  private CatalogueServiceImpl catalogueService;

  @Mock
  private WatchRepository watchRepository;

  @Before
  public void setup() {
    when(watchRepository.getOne(TestConstants.watchID1))
        .thenReturn(TestConstants.watch1);
    when(watchRepository.getOne(TestConstants.watchID2))
        .thenReturn(TestConstants.watch2);
    when(watchRepository.getOne(TestConstants.watchID3))
        .thenReturn(TestConstants.watch3);
  }

  @Test
  public void checkoutSuccess_NoDiscount() {
    CheckoutResponse response = catalogueService
        .checkout(TestConstants.watchIdsNoDiscount);

    Assert.assertEquals(response, TestConstants.watchIdsNoDiscountCatalogueServiceResponse);
  }

  @Test
  public void checkoutSuccess_WithDiscount() {
    CheckoutResponse response = catalogueService
        .checkout(TestConstants.watchIdsWithDiscount);

    Assert.assertEquals(response, TestConstants.watchIdsWithDiscountCatalogueServiceResponse);
  }

  @After
  public void destroy() {
    reset(watchRepository);
  }
}