package ie.atu.comparepriceskm.Controller;

import ie.atu.comparepriceskm.Service.PricesService;
import ie.atu.comparepriceskm.dto.FuelStationResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping
    public List<FuelStationResponseDTO> getAllStations() {
        return pricesService.getAllStations();
    }

    @GetMapping("/location/{location}")
    public List<FuelStationResponseDTO> getStationsByLocation(@PathVariable String location) {
        return pricesService.getStationsByLocation(location);
    }

    @GetMapping("/cheapest/petrol")
    public List<FuelStationResponseDTO> getCheapestPetrol() {
        return pricesService.getCheapestPetrol();
    }

    @GetMapping("/cheapest/diesel")
    public List<FuelStationResponseDTO> getCheapestDiesel() {
        return pricesService.getCheapestDiesel();
    }
}
