package com.bankbazaar.service;

import com.bankbazaar.model.ActorServiceRequest;
import com.bankbazaar.model.ActorServiceResponse;
import com.bankbazaar.model.workflow.RetryWorkflowItem;
import com.bankbazaar.model.workflow.WorkflowActionType;
import com.bankbazaar.model.workflow.retry.WorkflowRetryStrategyType;

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

    @Path("/getRetryStrategy")
    @GET
    WorkflowRetryStrategyType getRetryStrategy(ActorServiceRequest request);

    @Path("/getMaxRetryCount")
    @GET
    Integer getMaxRetryCount(ActorServiceRequest request);

    @Path("/getActorType")
    @GET
    WorkflowActionType getActorType(ActorServiceRequest request);

    @Path("/onMaxRetries")
    @POST
    void onMaxRetriesExceeded(RetryWorkflowItem retryWorkflowItem, ActorServiceRequest request);

}