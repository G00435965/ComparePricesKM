package ie.atu.comparepriceskm.Service;


import ie.atu.comparepriceskm.Model.PricesHistory;
import ie.atu.comparepriceskm.Model.PricesInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricesService {

    private final List<PricesInformation> prices = new ArrayList<>(); //stores current prices
    private final List<PricesHistory> history = new ArrayList<>(); //stores history of prices


    public List<PricesInformation> getAll() {
        return prices;
    }

    public List<PricesHistory> getHistory() {
        return history;
    }


// this is for adding/ updating prices
    public PricesInformation addOrUpdate(PricesInformation newPrice) {

        for (PricesInformation existing : prices) { //this will check the prices

            if (existing.getStationName().equalsIgnoreCase(newPrice.getStationName()) //if the station exists
                    && existing.getFuelType().equalsIgnoreCase(newPrice.getFuelType())) { //if the fuel type exists

                if (newPrice.getPrice() > existing.getPrice()) {
                    saveHistory(existing, newPrice, "Price has gone UP"); //checks if the new price is higher than the original one
                }
                else if (newPrice.getPrice() < existing.getPrice()) {
                    saveHistory(existing, newPrice, "Price has gone DOWN"); //checks if the new price is lower than the original one
                }

                existing.setPrice(newPrice.getPrice());
                return existing; //returns the updated price
            }
        }

        prices.add(newPrice);
        return newPrice;
    }

    //for recording price change and sending it to the history list.
    private void saveHistory(PricesInformation oldPrice,
                             PricesInformation newPrice,
                             String changeType) {



        PricesHistory record = new PricesHistory(
                oldPrice.getStationName(),   // which station
                oldPrice.getFuelType(),      // petrol or diesel
                oldPrice.getPrice(),         // old price
                newPrice.getPrice(),         // new price
                changeType                  // prices UP or DOWN
        );

        // this is for recording the history
        history.add(record);
    }



}
