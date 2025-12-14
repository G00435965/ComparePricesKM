package ie.atu.comparepriceskm.Service;


import ie.atu.comparepriceskm.Model.PricesHistory;
import ie.atu.comparepriceskm.Model.PricesInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricesService {

    private final List<PricesInformation> prices = new ArrayList<>(); //linking to Inofrmation
    private final List<PricesHistory> history = new ArrayList<>(); //Linking to history


    public List<PricesInformation> getAll() {
        return prices;
    }

    public List<PricesHistory> getHistory() {
        return history;
    }



    public PricesInformation addOrUpdate(PricesInformation newPrice) {

        for (PricesInformation existing : prices) {

            if (existing.getStationName().equalsIgnoreCase(newPrice.getStationName())
                    && existing.getFuelType().equalsIgnoreCase(newPrice.getFuelType())) {

                if (newPrice.getPrice() > existing.getPrice()) {
                    saveHistory(existing, newPrice, "Price has gone UP");
                }
                else if (newPrice.getPrice() < existing.getPrice()) {
                    saveHistory(existing, newPrice, "Price has gone DOWN");
                }

                existing.setPrice(newPrice.getPrice());
                return existing;
            }
        }

        prices.add(newPrice);
        return newPrice;
    }



}
