package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends AbstractActor {

    private Animation animation;
    private int numOfUsages;

    public Hammer(){
        animation = new Animation("sprites/hammer.png", 16, 16);
        setAnimation(animation);
        numOfUsages = 1;
    }

    public Hammer(int numOfUsages){
        this();
        this.numOfUsages = numOfUsages;

    }

    public int getNumOfUsages(){
        return numOfUsages;
    }

    public void use(){
        if(numOfUsages>0) {
            numOfUsages--;
            if (numOfUsages == 0) {
                this.getScene().removeActor(this);
            }
        }
    }

    protected void setNumOfUsages(int numOfUsages){
        this.numOfUsages = numOfUsages;
    }
}
