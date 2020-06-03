package com.maha.ecommerce.service;

import com.maha.ecommerce.dto.CheckoutResponse;
import com.maha.ecommerce.model.Watch;
import com.maha.ecommerce.repository.WatchRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogueServiceImpl implements CatalogueService {

  private WatchRepository watchRepository;

  @Override
  public CheckoutResponse checkout(List<String> watchIds) {
    //just pass on price for first watch for now
    Watch fetchedWatch = watchRepository.getOne(watchIds.get(0));
    return new CheckoutResponse().builder()
        .price(fetchedWatch.getPrice())
        .build();
  }
}
