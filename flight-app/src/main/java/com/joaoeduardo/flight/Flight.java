package com.joaoeduardo.flight;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Flight extends PanacheEntity {

    public Long travelOrderId;
    @NonNull
    public String fromAirport;
    @NonNull
    public String toAirport;

    public static Flight findByTravelOrderId(Long travelOrderId){
        return find("travelOrderId", travelOrderId).firstResult();
    }



}
