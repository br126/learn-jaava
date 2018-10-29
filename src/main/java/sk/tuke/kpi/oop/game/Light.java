package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor {

    private Animation lightOnAnimation;
    private Animation lightOffAnimation;
    private boolean state;
    private boolean electricity;


    public Light(){
        state = false;
        electricity = false;
        lightOffAnimation = new Animation("sprites/light_off.png", 16, 16);
        lightOnAnimation = new Animation("sprites/light_on.png", 16, 16);
        updateAnimation();
    }

    public void toggle(){
        if (state){
            state = false;
        }else {
            state = true;
        }
        updateAnimation();
    }

    private void updateAnimation(){
        if (state && electricity){
            setAnimation(lightOnAnimation);
        }else {
            setAnimation(lightOffAnimation);
        }
    }

    public void setElectricityFlow(boolean electricity){
        this.electricity = electricity;
        updateAnimation();
    }





}
