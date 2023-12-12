package com.joaoeduardo.travelorder;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8081/flights")
public interface FlightService {


    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight findById(@QueryParam("id") long id);

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight findByTravelOrderId(@QueryParam("travelOrderId") long travelOrderId);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Flight newFlight(Flight flight);


}
