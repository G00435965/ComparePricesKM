package ie.atu.comparepriceskm.Controller;

import ie.atu.comparepriceskm.Model.FuelStation;
import ie.atu.comparepriceskm.Service.PricesService;
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
    public List<FuelStation> getAllStations() {
        return pricesService.getAllStations();
    }

    @GetMapping("/location/{location}")
    public List<FuelStation> getStationsByLocation(@PathVariable String location) {
        return pricesService.getStationsByLocation(location);
    }

    @GetMapping("/cheapest/petrol")
    public List<FuelStation> getCheapestPetrol() {
        return pricesService.getCheapestPetrol();
    }

    @GetMapping("/cheapest/diesel")
    public List<FuelStation> getCheapestDiesel() {
        return pricesService.getCheapestDiesel();
    }
}
