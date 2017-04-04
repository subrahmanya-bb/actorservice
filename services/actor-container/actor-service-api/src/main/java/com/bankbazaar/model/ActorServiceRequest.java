package com.bankbazaar.model;

import com.bankbazaar.workflow.IActionable;

/**
 * Created by subrahmanya on 4/4/17.
 */
public class ActorServiceRequest {

    private String actorName;

    private IActionable actionable;

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public IActionable getActionable() {
        return actionable;
    }

    public void setActionable(IActionable actionable) {
        this.actionable = actionable;
    }
}
