package id.mhafizsir.dottesttask.repository;

import id.mhafizsir.dottesttask.entity.Provinces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvincesRepository extends JpaRepository<Provinces, Integer> {

}
