package com.maha.ecommerce.controller;

import com.maha.ecommerce.dto.CheckoutResponse;
import com.maha.ecommerce.service.CatalogueService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CatalogueController {

  private CatalogueService catalogueService;

  @RequestMapping(value = "/checkout", method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<CheckoutResponse> checkout(@RequestBody List<String> watchIds) {
    return ResponseEntity.ok().body(catalogueService.checkout(watchIds));
  }
}
