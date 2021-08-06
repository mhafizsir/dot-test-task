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
public class ProvinceResponse {

  private List<ProvinceResponseQuery> query;
  private ProvinceResponseStatus status;
  private List<ProvinceResponseResults> results;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class ProvinceResponseQuery {

    private String id;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class ProvinceResponseStatus {

    private Integer code;
    private String description;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(Include.NON_NULL)
  public static class ProvinceResponseResults {

    @JsonProperty("province_id")
    private String provinceId;
    private String province;
  }
}
