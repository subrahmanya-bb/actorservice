package com.bankbazaar.service;

import com.bankbazaar.model.ActorServiceRequest;
import com.bankbazaar.model.ActorServiceResponse;

import javax.ws.rs.*;

/**
 * Created by subrahmanya on 4/4/17.
 */

@Path("/")
@Produces("application/json")
@Consumes("application/json")
public interface ActorService {

    @Path("/submit")
    @POST
    ActorServiceResponse act(ActorServiceRequest request);

    @Path("/checkCompletion")
    @POST
    ActorServiceResponse checkCompletion(ActorServiceRequest request);

    @Path("/ping")
    @GET
    String ping();

}