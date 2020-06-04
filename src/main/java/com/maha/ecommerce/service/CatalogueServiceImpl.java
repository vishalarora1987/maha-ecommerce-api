package com.maha.ecommerce.service;

import com.maha.ecommerce.dto.CheckoutResponse;
import com.maha.ecommerce.model.Watch;
import com.maha.ecommerce.repository.WatchRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogueServiceImpl implements CatalogueService {

  private WatchRepository watchRepository;

  @Override
  public CheckoutResponse checkout(List<String> watchIds) {
    //convert list to map with watch id & frequency
    Map<String, Long> watchIdFrequencyMap = watchIds
        .stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));

    //get the set containing watch ids and its frequency from the map
    Set<Entry<String, Long>> watchIdsSetWithFrequency = watchIdFrequencyMap.entrySet();

    //calculate price with discount applied
    BigDecimal totalPrice = BigDecimal.ZERO;
    for (Entry<String, Long> watchIdWithFrequency : watchIdsSetWithFrequency) {
      totalPrice = totalPrice.add(calculatePrice(watchIdWithFrequency));
    }

    return new CheckoutResponse().builder()
        .price(totalPrice)
        .build();
  }

  private BigDecimal calculatePrice(Entry<String, Long> watchIdWithFrequency) {
    Watch fetchedWatch = watchRepository.getOne(watchIdWithFrequency.getKey());
    long quantity = watchIdWithFrequency.getValue();

    //If no discount is applicable for current watch, we simply calculate price and return
    if (fetchedWatch.getDiscount() == null) {
      BigDecimal totalPrice = fetchedWatch.getPrice().multiply(new BigDecimal(quantity));
      return totalPrice;
    }

    //If discount is applicable first find quantity on which discount is applicable, then
    //multiply with discounted price and next add normal price for remaining items
    BigDecimal totalPrice = fetchedWatch
        .getDiscount()
        .getDiscountedAmount()
        .multiply(
            new BigDecimal((quantity / (fetchedWatch.getDiscount().getDiscountedQuantity()))))
        .add(fetchedWatch
            .getPrice()
            .multiply(
                new BigDecimal((quantity % fetchedWatch.getDiscount().getDiscountedQuantity()))));
    return totalPrice;
  }
}
