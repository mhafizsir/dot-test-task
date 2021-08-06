package id.mhafizsir.dottesttask.client;

import id.mhafizsir.dottesttask.model.CityResponse;
import id.mhafizsir.dottesttask.model.CostRequest;
import id.mhafizsir.dottesttask.model.CostResponse;
import id.mhafizsir.dottesttask.model.ProvinceResponse;
import java.io.IOException;

public interface RajaOngkirClient {

  ProvinceResponse fetchAllProvinces() throws IOException;

  ProvinceResponse fetchProvinceById(String provinceId);

  CityResponse fetchAllCities() throws IOException;

  CityResponse fetchCityById(String cityId);

  CostResponse calculateCost(CostRequest costRequest) throws IOException;
}
