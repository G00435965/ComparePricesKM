package ie.atu.comparepriceskm.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prices")
public class PricesController {

    private final PricesService service;

    public PricesController(PricesService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public PriceInformation addPrice(@RequestBody PriceInformation price) {
        return service.addOrUpdate(price);
    }

    @GetMapping("/getAll")
    public List<PriceInformation> getAllPrices() {
        return service.getAll();
    }

    @GetMapping("/history")
    public List<PriceHistory> getHistory() {
        return service.getHistory();
    }
}