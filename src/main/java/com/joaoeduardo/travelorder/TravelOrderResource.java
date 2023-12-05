package com.joaoeduardo.travelorder;

import com.joaoeduardo.flight.Flight;
import com.joaoeduardo.flight.FlightResource;
import com.joaoeduardo.hotel.Hotel;
import com.joaoeduardo.hotel.HotelResource;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("travelorders")
public class TravelOrderResource {

    @Inject
    private FlightResource flightResource;

    @Inject
    private HotelResource hotelResource;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders(){

        return TravelOrder.<TravelOrder>listAll().stream()
                .map(
                        order -> TravelOrderDTO.of(
                                order,
                                flightResource.findByTravelOrderId(order.id),
                                hotelResource.findByTravelOrderId(order.id)
                        )
                ).toList();

    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrderDTO findById(@QueryParam("id") long id){

        TravelOrder order = TravelOrder.findById(id);

        TravelOrderDTO orderDTO = TravelOrderDTO.of(
                order,
                flightResource.findByTravelOrderId(order.id),
                hotelResource.findByTravelOrderId(order.id)
        );

        return orderDTO;
    }



    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TravelOrderDTO newTravelOrder(TravelOrderDTO orderDTO){
        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        flightResource.newFlight(new Flight(order.id, orderDTO.getFromAirport(), orderDTO.getToAirport()));

        hotelResource.newHotel(new Hotel(order.id, orderDTO.getNights()));

        TravelOrderDTO travelOrderDTO = TravelOrderDTO.of(
                order,
                flightResource.findByTravelOrderId(order.id),
                hotelResource.findByTravelOrderId(order.id)
        );

        return travelOrderDTO;
    }

}
