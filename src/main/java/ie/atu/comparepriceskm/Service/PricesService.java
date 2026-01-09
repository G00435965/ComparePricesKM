package ie.atu.comparepriceskm.Service;

import ie.atu.comparepriceskm.ErrorHandling.LocationException;
import ie.atu.comparepriceskm.ErrorHandling.NoStationsException;
import ie.atu.comparepriceskm.Model.FuelStation;
import ie.atu.comparepriceskm.Repository.FuelStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesService {

    private final FuelStationRepository fuelStationRepository;

    public PricesService(FuelStationRepository fuelStationRepository) {
        this.fuelStationRepository = fuelStationRepository;
    }

    public List<FuelStation> getAllStations() {
        return fuelStationRepository.findAll();
    }

    public List<FuelStation> getStationsByLocation(String location) {

        if (location == null || location.trim().isEmpty()) {
            throw new LocationException("Location is required.");
        }

        List<FuelStation> stations =
                fuelStationRepository.findByLocationIgnoreCase(location.trim());

        // Option A: treat "not found" same as invalid -> 400
        if (stations.isEmpty()) {
            throw new LocationException("No stations found for location: " + location);
        }

        return stations;
    }

    public List<FuelStation> getCheapestPetrol() {
        List<FuelStation> stations = fuelStationRepository.findAllByOrderByPetrolPriceAsc();

        if (stations.isEmpty()) {
            throw new NoStationsException("No stations available to compare petrol prices.");
        }

        return stations;
    }

    public List<FuelStation> getCheapestDiesel() {
        List<FuelStation> stations = fuelStationRepository.findAllByOrderByDieselPriceAsc();

        if (stations.isEmpty()) {
            throw new NoStationsException("No stations available to compare diesel prices.");
        }

        return stations;
    }
}
