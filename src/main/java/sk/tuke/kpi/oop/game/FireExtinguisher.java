package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class FireExtinguisher extends AbstractActor {

    private int numOfUsages;

    public FireExtinguisher(){
        numOfUsages = 0;
        setAnimation(new Animation("sprites/extinguisher.png", 16, 16));
    }

    public void use(){
        if(numOfUsages>0) {
            numOfUsages--;
            if (numOfUsages == 0) {
                this.getScene().removeActor(this);
            }
        }
    }

    public int getNumOfUsages() {
        return numOfUsages;
    }
}
