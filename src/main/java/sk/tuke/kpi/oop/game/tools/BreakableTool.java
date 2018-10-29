package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.framework.AbstractActor;

public abstract class BreakableTool extends AbstractActor {

    protected int remainingUses;

    public BreakableTool(int remainingUses){
        this.remainingUses = remainingUses;
    }

    public void use(){
        if(remainingUses > 0){
            remainingUses--;
            if(remainingUses == 0) {
                this.getScene().removeActor(this);
            }
        }
    }

    public int getRemainingUses(){
        return remainingUses;
    }

    protected void setRemainingUses(int numOfUsages){
        this.remainingUses = numOfUsages;
    }
}
