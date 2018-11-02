package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Cooler extends AbstractActor {

    private boolean isOn;
    private Animation coolerAnimation;
    //private Animation coolerOff;
    private Reactor reactor;


    public Cooler(Reactor reactor){
        this.isOn = false;
        coolerAnimation = new Animation("sprites/fan.png", 32, 32, 0.2f);
        //coolerOff = new Animation("images/fanOff.png", 32, 32);
        coolerAnimation.stop();
        setAnimation(coolerAnimation);
        this.reactor = reactor;
        //this.setCooledReactor(reactor);


    }

    private void coolReactor(){
        if(isOn()){
            reactor.decreaseTemperature(1);
        }
    }

    public void turnOn() {
        if (!isOn) {
            this.isOn = true;
        }
        updateAnimation();
        // updateLight();
    }

    public void turnOff() {
        if (isOn) {
            this.isOn = false;
        }
        updateAnimation();
        //updateLight();
    }

    private boolean isOn(){
        return isOn;
    }

    private void updateAnimation(){
        if(isOn()){
            coolerAnimation.play();
            this.setAnimation(coolerAnimation);
            //this.coolerAnimation.start();
        }else {
            coolerAnimation.stop();
            this.setAnimation(coolerAnimation);
        }
    }
}
