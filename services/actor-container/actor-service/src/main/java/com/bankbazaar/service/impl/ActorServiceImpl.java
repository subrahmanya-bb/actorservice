package com.bankbazaar.service.impl;

import com.bankbazaar.model.ActorServiceRequest;
import com.bankbazaar.model.ActorServiceResponse;
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


            IActor actorObject = actorServiceRequest.getActor();
            ActorResponse response = actorObject.act(actorServiceRequest.getActionable());

            ActorServiceResponse actorServiceResponse = new ActorServiceResponse();
            actorServiceResponse.setActorResponse(response);

            return actorServiceResponse;

            // OR we can use below.

            /*
            Method method = actorClass.getMethod("act", actorClass);
            method.invoke(actorClass.newInstance(), request.getActionable());
            */

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ActorServiceResponse checkCompletion(ActorServiceRequest actorServiceRequest) {

        Class<?> actorClass = null;
        try {

            IActor actorObject = actorServiceRequest.getActor();
            ActorResponse response = actorObject.checkCompletion(actorServiceRequest.getActionable());

            ActorServiceResponse actorServiceResponse = new ActorServiceResponse();
            actorServiceResponse.setActorResponse(response);

            return actorServiceResponse;

            // OR we can use below.

            /*
            Method method = actorClass.getMethod("checkCompletion", actorClass);
            method.invoke(actorClass.newInstance(), request.getActionable());
            */


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String ping() {
        return Boolean.TRUE.toString();
    }

}
