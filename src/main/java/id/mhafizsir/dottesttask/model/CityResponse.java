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
public class CityResponse {

  private List<CityResponseQuery> query;
  private CityResponseStatus status;
  private List<CityResponseResults> results;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class CityResponseQuery {

    private String id;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class CityResponseStatus {

    private Integer code;
    private String description;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class CityResponseResults {

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
}