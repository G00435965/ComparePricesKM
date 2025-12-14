package ie.atu.comparepriceskm.Controller;


import ie.atu.comparepriceskm.Model.PricesHistory;
import ie.atu.comparepriceskm.Model.PricesInformation;
import ie.atu.comparepriceskm.Service.PricesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PricesController {

    private final PricesService service;

    public PricesController(PricesService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public PricesInformation addPrice(@RequestBody PricesInformation price) {
        return service.addOrUpdate(price);
    }

    @GetMapping("/getAll")
    public List<PricesInformation> getAllPrices() {
        return service.getAll();
    }

    @GetMapping("/history")
    public List<PricesHistory> getHistory() {
        return service.getHistory();
    }
}