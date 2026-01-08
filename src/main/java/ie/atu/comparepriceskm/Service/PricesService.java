package ie.atu.comparepriceskm.Service;

import ie.atu.comparepriceskm.Model.FuelStation;
import ie.atu.comparepriceskm.Repository.FuelStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesService {

    private final FuelStationRepository fuelStationRepository;

    // Constructor injection (lab-approved style)
    public PricesService(FuelStationRepository fuelStationRepository) {
        this.fuelStationRepository = fuelStationRepository;
    }

    // Get all fuel stations
    public List<FuelStation> getAllStations() {
        return fuelStationRepository.findAll();
    }

    // Get stations by location
    public List<FuelStation> getStationsByLocation(String location) {
        return fuelStationRepository.findByLocationIgnoreCase(location);
    }

    // Get cheapest petrol stations
    public List<FuelStation> getCheapestPetrol() {
        return fuelStationRepository.findAllByOrderByPetrolPriceAsc();
    }

    // Get cheapest diesel stations
    public List<FuelStation> getCheapestDiesel() {
        return fuelStationRepository.findAllByOrderByDieselPriceAsc();
    }
}