package id.mhafizsir.dottesttask.controller;

import id.mhafizsir.dottesttask.model.CostRequest;
import id.mhafizsir.dottesttask.service.RajaOngkirService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rajaongkir")
public class RajaOngkirController {

  private final RajaOngkirService rajaOngkirService;

  @GetMapping("/province")
  public ResponseEntity<Object> fetchAllProvinces() {
    try {
      log.debug("TEST LOGGING DEBUG");
      return ResponseEntity.ok(rajaOngkirService.fetchAllProvinces());
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("There's Something Wrong In The Server, Please Contact System Administrator");
    }
  }

  @GetMapping("/city")
  public ResponseEntity<Object> fetchAllCities() {
    try {
      log.info("TEST LOGGING INFO");
      return ResponseEntity.ok(rajaOngkirService.fetchAllCities());
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("There's Something Wrong In The Server, Please Contact System Administrator");
    }
  }

  @PostMapping("/calculate-cost")
  public ResponseEntity<Object> calculateCost(@RequestBody CostRequest costRequest) {
    try {
      log.warn("TEST LOGGING WARN");
      return ResponseEntity.ok(rajaOngkirService.calculateCost(costRequest));
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("There's Something Wrong In The Server, Please Contact System Administrator");
    }
  }
}
