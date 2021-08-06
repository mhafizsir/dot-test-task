package id.mhafizsir.dottesttask.service;

import id.mhafizsir.dottesttask.client.RajaOngkirClient;
import id.mhafizsir.dottesttask.entity.Cities;
import id.mhafizsir.dottesttask.entity.Provinces;
import id.mhafizsir.dottesttask.model.CityResponse;
import id.mhafizsir.dottesttask.model.CityResponse.CityResponseResults;
import id.mhafizsir.dottesttask.model.CostRequest;
import id.mhafizsir.dottesttask.model.CostResponse;
import id.mhafizsir.dottesttask.model.ProvinceResponse;
import id.mhafizsir.dottesttask.model.ProvinceResponse.ProvinceResponseResults;
import id.mhafizsir.dottesttask.repository.CitiesRepository;
import id.mhafizsir.dottesttask.repository.ProvincesRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RajaOngkirServiceImpl implements RajaOngkirService {

  private final RajaOngkirClient rajaOngkirClient;
  private final ProvincesRepository provincesRepository;
  private final CitiesRepository citiesRepository;

  @Override
  public List<Provinces> fetchAllProvinces() throws IOException {

    var provinceResponse = rajaOngkirClient.fetchAllProvinces();
    if (provinceResponse.getStatus().getCode() == 200) {
      for (ProvinceResponseResults prr : provinceResponse.getResults()) {
        var province = Provinces.builder()
            .provinceId(prr.getProvinceId())
            .provinceName(prr.getProvince())
            .createdAt(new Date())
            .build();
        provincesRepository.save(province);
      }
      return provincesRepository.findAll();
    } else {
      return new ArrayList<>();
    }
  }

  @Override
  public ProvinceResponse fetchProvinceById(String provinceId) {
    return null;
  }

  @Override
  public List<Cities> fetchAllCities() throws IOException {
    var cityResponse = rajaOngkirClient.fetchAllCities();
    if (cityResponse.getStatus().getCode() == 200) {
      for (CityResponseResults crr : cityResponse.getResults()) {
        var city = Cities.builder()
            .provinceId(crr.getProvinceId())
            .provinceName(crr.getProvince())
            .cityId(crr.getCityId())
            .cityName(crr.getCityName())
            .postalCode(crr.getPostalCode())
            .type(crr.getType())
            .createdAt(new Date())
            .build();
        citiesRepository.save(city);
      }
      return citiesRepository.findAll();
    } else {
      return new ArrayList<>();
    }
  }

  @Override
  public CityResponse fetchCityById(String cityId) {
    return null;
  }

  @Override
  public CostResponse calculateCost(CostRequest costRequest) throws IOException {

    return rajaOngkirClient.calculateCost(costRequest);
  }
}
