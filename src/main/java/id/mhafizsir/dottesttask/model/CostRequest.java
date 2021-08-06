package id.mhafizsir.dottesttask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostRequest {

  private String origin;
  private String destination;
  private Integer weight;
  private String courier;
}
