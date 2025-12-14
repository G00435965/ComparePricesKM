package ie.atu.comparepriceskm.Service;


import ie.atu.comparepriceskm.Model.PricesHistory;
import ie.atu.comparepriceskm.Model.PricesInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricesService {

    private final List<PricesInformation> prices = new ArrayList<>();
    private final List<PricesHistory> history = new ArrayList<>();

    public List<PricesInformation> getAll() {
        return prices;
    }

    public List<PricesHistory> getHistory() {
        return history;
    }


}
