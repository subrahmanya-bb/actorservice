package com.bankbazaar.model;

import com.bankbazaar.workflow.IActionable;
import com.bankbazaar.workflow.IActor;

/**
 * Created by subrahmanya on 4/4/17.
 */
public class ActorServiceRequest {

    private IActor actor;

    private IActionable actionable;

    public IActor getActor() {
        return actor;
    }

    public void setActor(IActor actor) {
        this.actor = actor;
    }

    public IActionable getActionable() {
        return actionable;
    }

    public void setActionable(IActionable actionable) {
        this.actionable = actionable;
    }
}
