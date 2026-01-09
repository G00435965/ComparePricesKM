package ie.atu.comparepriceskm.Model;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PricesInformation {

    @NotBlank(message = "The station name is required")
    private String stationName;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;   // Petrol or Diesel

    @DecimalMin(value = "1.0", message = "Fuel price must be more than or equal to €1")
    private double price;

}
