package ie.atu.comparepriceskm.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fuel_station")
public class FuelStation {

    @Id
    private Long id;

    private String stationName;
    private double petrolPrice;
    private double dieselPrice;
    private String location;
}