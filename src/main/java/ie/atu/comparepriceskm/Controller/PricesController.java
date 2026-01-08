package ie.atu.comparepriceskm.Controller;


import ie.atu.comparepriceskm.Model.FuelStation;
import ie.atu.comparepriceskm.Service.PricesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final PricesService pricesService;

    // Constructor injection (lab style)
    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    // Get all fuel stations
    @GetMapping
    public List<FuelStation> getAllStations() {
        return pricesService.getAllStations();
    }

    // Get stations by location
    // Example: /prices/location/Galway
    @GetMapping("/location/{location}")
    public List<FuelStation> getStationsByLocation(@PathVariable String location) {
        return pricesService.getStationsByLocation(location);
    }

    // Get cheapest petrol stations
    // Example: /prices/cheapest/petrol
    @GetMapping("/cheapest/petrol")
    public List<FuelStation> getCheapestPetrol() {
        return pricesService.getCheapestPetrol();
    }

    // Get cheapest diesel stations
    // Example: /prices/cheapest/diesel
    @GetMapping("/cheapest/diesel")
    public List<FuelStation> getCheapestDiesel() {
        return pricesService.getCheapestDiesel();
    }
}