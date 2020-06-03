package com.maha.ecommerce.service;

import com.maha.ecommerce.dto.CheckoutResponse;
import java.util.List;

public interface CatalogueService {
  public CheckoutResponse checkout(List<String> watchIds);
}
