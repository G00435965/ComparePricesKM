package ie.atu.comparepriceskm.Repository;

import ie.atu.comparepriceskm.Model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelStationRepository extends JpaRepository<FuelStation, Long> {

    // Find stations by location (case-insensitive)
    List<FuelStation> findByLocationIgnoreCase(String location);

    // Find stations ordered by petrol price (ascending = cheapest first)
    List<FuelStation> findAllByOrderByPetrolPriceAsc();

    // Find stations ordered by diesel price (ascending = cheapest first)
    List<FuelStation> findAllByOrderByDieselPriceAsc();
}
