package id.mhafizsir.dottesttask.service;

import id.mhafizsir.dottesttask.entity.Cities;
import id.mhafizsir.dottesttask.entity.Provinces;
import id.mhafizsir.dottesttask.model.CityResponse;
import id.mhafizsir.dottesttask.model.CostRequest;
import id.mhafizsir.dottesttask.model.CostResponse;
import id.mhafizsir.dottesttask.model.ProvinceResponse;
import java.io.IOException;
import java.util.List;

public interface RajaOngkirService {

  List<Provinces> fetchAllProvinces() throws IOException;

  ProvinceResponse fetchProvinceById(String provinceId);

  List<Cities> fetchAllCities() throws IOException;

  CityResponse fetchCityById(String cityId);

  CostResponse calculateCost(CostRequest costRequest) throws IOException;
}
