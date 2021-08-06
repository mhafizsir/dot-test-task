package id.mhafizsir.dottesttask.repository;

import id.mhafizsir.dottesttask.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Integer> {

}
