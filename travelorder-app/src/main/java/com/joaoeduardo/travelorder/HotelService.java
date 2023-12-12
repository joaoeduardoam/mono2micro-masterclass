package com.joaoeduardo.travelorder;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8082/hotels")
public interface HotelService {


    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findById(@QueryParam("id") long id);

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findByTravelOrderId(@QueryParam("travelOrderId") long travelOrderId);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Hotel newHotel(Hotel hotel);


}
