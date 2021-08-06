package id.mhafizsir.dottesttask.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.mhafizsir.dottesttask.model.CityResponse;
import id.mhafizsir.dottesttask.model.CostRequest;
import id.mhafizsir.dottesttask.model.CostResponse;
import id.mhafizsir.dottesttask.model.ProvinceResponse;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RajaOngkirClientImpl implements RajaOngkirClient {

  private final OkHttpClient client = new OkHttpClient();

  @Value("${rajaongkir.baseurl.starter}")
  private String baseUrl;
  @Value("${raajongkir.api.key}")
  private String apiKey;

  @Override
  public ProvinceResponse fetchAllProvinces() throws IOException {
    try {
      var httpRequest = new Request.Builder()
          .url(String.format("%s/province", baseUrl))
          .header("key", apiKey)
          .build();

      var response = client.newCall(httpRequest).execute();
      log.info("Response = {}", response);
      return new ObjectMapper().enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
          .readValue(Objects.requireNonNull(response.body()).string(),
              ProvinceResponse.class);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public ProvinceResponse fetchProvinceById(String provinceId) {
    return null;
  }

  @Override
  public CityResponse fetchAllCities() throws IOException {
    try {
      var httpRequest = new Request.Builder()
          .url(String.format("%s/city", baseUrl))
          .header("key", apiKey)
          .build();

      var response = client.newCall(httpRequest).execute();
      log.info("Response = {}", response);
      return new ObjectMapper().enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
          .readValue(Objects.requireNonNull(response.body()).string(),
              CityResponse.class);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public CityResponse fetchCityById(String cityId) {
    return null;
  }

  @Override
  public CostResponse calculateCost(CostRequest request) throws IOException {
    try {
      var formRequest = new FormBody.Builder()
          .add("origin", request.getOrigin())
          .add("destination", request.getDestination())
          .add("weight", Integer.toString(request.getWeight()))
          .add("courier", request.getCourier())
          .build();
      var httpRequest = new Request.Builder()
          .url(String.format("%s/cost", baseUrl))
          .header("key", apiKey)
          .post(formRequest)
          .build();

      var response = client.newCall(httpRequest).execute();
      log.info("Response = {}", response);
      return new ObjectMapper().enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
          .readValue(Objects.requireNonNull(response.body()).string(),
              CostResponse.class);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }
}
