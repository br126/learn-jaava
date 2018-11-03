package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;


public class Cooler extends AbstractActor {

    protected boolean isOn;
    private Animation coolerAnimation;
    //private Animation coolerOff;
    protected Reactor reactor;


    public Cooler(Reactor reactor){
        this.isOn = false;
        coolerAnimation = new Animation("sprites/fan.png", 32, 32, 0.2f);
        //coolerOff = new Animation("images/fanOff.png", 32, 32);
        coolerAnimation.stop();
        setAnimation(coolerAnimation);
        this.reactor = reactor;
        //this.setCooledReactor(reactor);


    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        //new Invoke(this::coolReactor).scheduleOn(this);
        //coolReactor();
        new Loop<>(new Invoke(this::coolReactor)).scheduleOn(this);
    }

    protected void coolReactor(){
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

    public Reactor getReactor() {
        return reactor;
    }
}
