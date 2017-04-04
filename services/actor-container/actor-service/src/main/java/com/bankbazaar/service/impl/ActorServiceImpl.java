package com.bankbazaar.service.impl;

import com.bankbazaar.model.ActorServiceRequest;
import com.bankbazaar.model.ActorServiceResponse;
import com.bankbazaar.model.workflow.RetryWorkflowItem;
import com.bankbazaar.model.workflow.WorkflowActionType;
import com.bankbazaar.model.workflow.retry.WorkflowRetryStrategyType;
import com.bankbazaar.service.ActorService;
import com.bankbazaar.workflow.ActorResponse;
import com.bankbazaar.workflow.IActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by subrahmanya on 4/4/17.
 */

public class ActorServiceImpl implements ActorService {

    private static final Logger LOG = LoggerFactory.getLogger(ActorServiceImpl.class);

    @Override
    public ActorServiceResponse act(ActorServiceRequest actorServiceRequest) {

        Class<?> actorClass = null;
        try {
            actorClass = Class.forName(actorServiceRequest.getActorName());

            IActor actorObject = (IActor) actorClass.newInstance();
            ActorResponse response = actorObject.act(actorServiceRequest.getActionable());

            ActorServiceResponse actorServiceResponse = new ActorServiceResponse();
            actorServiceResponse.setActorResponse(response);

            return actorServiceResponse;

            // OR we can use below.

            /*
            Method method = actorClass.getMethod("act", actorClass);
            method.invoke(actorClass.newInstance(), request.getActionable());
            */


        } catch (ClassNotFoundException e) {
            LOG.info("Invalid actor", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ActorServiceResponse checkCompletion(ActorServiceRequest actorServiceRequest) {

        Class<?> actorClass = null;
        try {
            actorClass = Class.forName(actorServiceRequest.getActorName());

            IActor actorObject = (IActor) actorClass.newInstance();
            ActorResponse response = actorObject.checkCompletion(actorServiceRequest.getActionable());

            ActorServiceResponse actorServiceResponse = new ActorServiceResponse();
            actorServiceResponse.setActorResponse(response);

            return actorServiceResponse;

            // OR we can use below.

            /*
            Method method = actorClass.getMethod("checkCompletion", actorClass);
            method.invoke(actorClass.newInstance(), request.getActionable());
            */


        } catch (ClassNotFoundException e) {
            LOG.info("Invalid actor", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WorkflowRetryStrategyType getRetryStrategy(ActorServiceRequest actorServiceRequest) {

        Class<?> actorClass = null;
        try {
            actorClass = Class.forName(actorServiceRequest.getActorName());

            IActor actorObject = (IActor) actorClass.newInstance();
            return actorObject.getRetryStrategy();

        } catch (ClassNotFoundException e) {
            LOG.info("Invalid actor", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Integer getMaxRetryCount(ActorServiceRequest actorServiceRequest) {

        Class<?> actorClass = null;
        try {
            actorClass = Class.forName(actorServiceRequest.getActorName());

            IActor actorObject = (IActor) actorClass.newInstance();
            return actorObject.getMaxRetryCount();

        } catch (ClassNotFoundException e) {
            LOG.info("Invalid actor", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WorkflowActionType getActorType(ActorServiceRequest actorServiceRequest) {

        Class<?> actorClass = null;
        try {
            actorClass = Class.forName(actorServiceRequest.getActorName());

            IActor actorObject = (IActor) actorClass.newInstance();
            return actorObject.getActorType();

        } catch (ClassNotFoundException e) {
            LOG.info("Invalid actor", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onMaxRetriesExceeded(RetryWorkflowItem retryWorkflowItem, ActorServiceRequest request) {

    }
}
