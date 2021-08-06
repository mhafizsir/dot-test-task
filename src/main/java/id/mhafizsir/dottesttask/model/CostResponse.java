package id.mhafizsir.dottesttask.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("rajaongkir")
@JsonInclude(Include.NON_NULL)
public class CostResponse {

  private CostResponseQuery query;
  private CostResponseStatus status;
  @JsonProperty("destination_details")
  private CostResponseOriginDestinationDetails destinationDetails;
  @JsonProperty("origin_details")
  private CostResponseOriginDestinationDetails originDetails;
  private List<CostResponseResult> results;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class CostResponseQuery {

    private String origin;
    private String destination;
    private Integer weight;
    private String courier;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class CostResponseStatus {

    private Integer code;
    private String description;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class CostResponseOriginDestinationDetails {

    @JsonProperty("city_id")
    private String cityId;
    @JsonProperty("province_id")
    private String provinceId;
    private String province;
    private String type;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("postal_code")
    private String postalCode;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class CostResponseResult {

    private String code;
    private String name;
    private List<CostResponseResultCost> costs;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(Include.NON_NULL)
    public static class CostResponseResultCost {

      private String service;
      private String description;
      private List<Cost> cost;

      @Data
      @NoArgsConstructor
      @AllArgsConstructor
      @JsonInclude(Include.NON_NULL)
      public static class Cost {

        private Integer value;
        private String etd;
        private String note;
      }
    }
  }
}
