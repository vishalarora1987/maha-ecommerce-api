package com.maha.ecommerce.service;

import com.maha.ecommerce.dto.CheckoutResponse;
import java.util.List;

public interface CatalogueService {
  CheckoutResponse checkout(List<String> watchIds);
}
