package ie.atu.comparepriceskm.Controller;


import ie.atu.comparepriceskm.Model.PricesHistory;
import ie.atu.comparepriceskm.Model.PricesInformation;
import ie.atu.comparepriceskm.Service.PricesService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PricesController {

    private final PricesService service; //connects controller to service

    public PricesController(PricesService service) {
        this.service = service;
    }

    //adding prices
    @PostMapping("/add")
    public PricesInformation addPrice(@Valid @RequestBody PricesInformation price) {
        return service.addOrUpdate(price);
    }

    //returns all prices
    @GetMapping("/getAll")
    public List<PricesInformation> getAllPrices() {
        return service.getAll();
    }

    //similar to logs it just returns the history of the prices
    @GetMapping("/history")
    public List<PricesHistory> getHistory() {
        return service.getHistory();
    }
}