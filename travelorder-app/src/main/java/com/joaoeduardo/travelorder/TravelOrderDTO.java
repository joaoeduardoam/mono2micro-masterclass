package com.joaoeduardo.travelorder;

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
        return new TravelOrderDTO(flight.getFromAirport(), flight.getToAirport(), hotel.getNights());
    }


    public static TravelOrderDTO of(TravelOrder order, Flight flight, Integer nights){
        return new TravelOrderDTO(flight.getFromAirport(), flight.getToAirport(), nights);
    }




}
