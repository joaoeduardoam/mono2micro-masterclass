package com.joaoeduardo.travelorder;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("travelorders")
public class TravelOrderResource {

    @Inject
    @RestClient
    private FlightService flightService;

    @Inject
    @RestClient
    private HotelService hotelService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders(){

        return TravelOrder.<TravelOrder>listAll().stream()
                .map(
                        order -> TravelOrderDTO.of(
                                order,
                                flightService.findByTravelOrderId(order.id),
                                hotelService.findByTravelOrderId(order.id)
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
                flightService.findByTravelOrderId(order.id),
                hotelService.findByTravelOrderId(order.id)
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

        flightService.newFlight(new Flight(order.id, orderDTO.getFromAirport(), orderDTO.getToAirport()));

        hotelService.newHotel(new Hotel(order.id, orderDTO.getNights()));

        TravelOrderDTO travelOrderDTO = TravelOrderDTO.of(
                order,
                flightService.findByTravelOrderId(order.id),
                hotelService.findByTravelOrderId(order.id)
        );

        return travelOrderDTO;
    }

}
