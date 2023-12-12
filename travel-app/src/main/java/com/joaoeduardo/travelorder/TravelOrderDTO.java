package com.joaoeduardo.travelorder;

import com.joaoeduardo.flight.Flight;
import com.joaoeduardo.hotel.Hotel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TravelOrderDTO{

    private String fromAirport;
    private String toAirport;
    private Integer nights;

    public static TravelOrderDTO of(TravelOrder order, Flight flight, Hotel hotel){
        if (flight == null){
            flight = new Flight();
        }
        if (hotel == null){
            hotel = new Hotel();
        }
        return new TravelOrderDTO(flight.fromAirport, flight.toAirport, hotel.nights);
    }


    public static TravelOrderDTO of(TravelOrder order, Flight flight, Integer nights){
        return new TravelOrderDTO(flight.fromAirport, flight.toAirport, nights);
    }




}
