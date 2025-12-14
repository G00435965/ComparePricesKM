package ie.atu.comparepriceskm.Model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PricesHistory {

    // Which stations price changed
    private String stationName;

    // Whether its petrol or diesel
    private String fuelType;

    // This is the original price
    private double oldPrice;

    // stores the new price higher or lower
    private double newPrice;

    // See if its gone up or down
    private String changeType;
}
