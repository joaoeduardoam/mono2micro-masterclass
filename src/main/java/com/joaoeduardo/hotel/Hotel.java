package com.joaoeduardo.hotel;

import com.joaoeduardo.flight.Flight;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel extends PanacheEntity {

    public Long travelOrderId;
    @NonNull
    public Integer nights;

    public static Hotel findByTravelOrderId(Long travelOrderId){
        return find("travelOrderId", travelOrderId).firstResult();
    }

}
