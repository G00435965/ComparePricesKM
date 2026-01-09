package ie.atu.comparepriceskm.Service;

import ie.atu.comparepriceskm.ErrorHandling.LocationException;
import ie.atu.comparepriceskm.ErrorHandling.NoStationsException;
import ie.atu.comparepriceskm.Model.FuelStation;
import ie.atu.comparepriceskm.Repository.FuelStationRepository;
import ie.atu.comparepriceskm.dto.FuelStationResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesService {

    private final FuelStationRepository fuelStationRepository;

    public PricesService(FuelStationRepository fuelStationRepository) {
        this.fuelStationRepository = fuelStationRepository;
    }

    public List<FuelStationResponseDTO> getAllStations() {
        return fuelStationRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public List<FuelStationResponseDTO> getStationsByLocation(String location) {

        if (location == null || location.trim().isEmpty()) {
            throw new LocationException("Location is required.");
        }

        List<FuelStation> stations =
                fuelStationRepository.findByLocationIgnoreCase(location.trim());

        if (stations.isEmpty()) {
            // Option A: same exception for invalid + not found (both 400)
            throw new LocationException("No stations found for location: " + location);
        }

        return stations.stream().map(this::toDto).toList();
    }

    public List<FuelStationResponseDTO> getCheapestPetrol() {
        List<FuelStation> stations = fuelStationRepository.findAllByOrderByPetrolPriceAsc();

        if (stations.isEmpty()) {
            throw new NoStationsException("No stations available to compare petrol prices.");
        }

        return stations.stream().map(this::toDto).toList();
    }

    public List<FuelStationResponseDTO> getCheapestDiesel() {
        List<FuelStation> stations = fuelStationRepository.findAllByOrderByDieselPriceAsc();

        if (stations.isEmpty()) {
            throw new NoStationsException("No stations available to compare diesel prices.");
        }

        return stations.stream().map(this::toDto).toList();
    }

    private FuelStationResponseDTO toDto(FuelStation station) {
        return new FuelStationResponseDTO(
                station.getStationName(),
                station.getPetrolPrice(),
                station.getDieselPrice(),
                station.getLocation()
        );
    }
}
