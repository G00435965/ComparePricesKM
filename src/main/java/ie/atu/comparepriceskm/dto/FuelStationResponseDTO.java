package ie.atu.comparepriceskm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuelStationResponseDTO {
    private String stationName;
    private double petrolPrice;
    private double dieselPrice;
    private String location;
}
