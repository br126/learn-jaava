package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;

public abstract class BreakableTool extends AbstractActor {

    private int remainingUses;

    public BreakableTool(int remainingUses){
        this.remainingUses = remainingUses;
    }

    public void use(){

    }
}
