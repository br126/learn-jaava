package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Reactor extends AbstractActor {

    private int temperature;
    private int damage;
    private boolean running;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation brokenAnimation;
    private Animation offAnimation;
    private Animation extinguishedAnimation;
    private Light light;

    public Reactor(){
        this.running = false;
        this.temperature = 0;
        this.damage = 0;
        // create animation object
        normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        hotAnimation = new Animation("sprites/reactor_hot.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        brokenAnimation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP);
        offAnimation = new Animation("sprites/reactor.png", 80, 80);
        extinguishedAnimation = new Animation("sprites/reactor_extinguished.png", 80, 80);
        updateAnimation();
    }


    public void addLight(Light light){
        if (light != null) {
            this.light = light;
            this.light.setElectricityFlow(running);
        }
    }

    public void removeLight(){
        if(light != null) {
            this.light.setElectricityFlow(false);
            this.light = null;
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDamage() {
        return damage;
    }

    public void increaseTemperature(int increment){
        if(increment > 0 && running) {
            if(damage < 33){
                this.temperature = temperature+increment;
            }
            else if(damage >= 33 && damage <= 66){
                this.temperature = (int) Math.ceil(temperature + increment*1.5);
            }else if(damage > 66){
                this.temperature = (int) Math.ceil(temperature + increment*2.0);
            }
            calculateDamage();
            if(damage == 100){
                turnOff();
            }
            if(light != null) {
                this.light.setElectricityFlow(running);
            }
            updateAnimation();
        }
    }

    public void decreaseTemperature(int decrement){
        if(decrement > 0 && running) {
            if(damage < 50){
                this.temperature = this.temperature - decrement;
                updateAnimation();
            }else if(damage >= 50 && damage < 100){
                this.temperature = this.temperature - (decrement/2);
                updateAnimation();
            }else {
                this.temperature = this.temperature - (decrement/2);
            }
            if(temperature<0){
                temperature = 0;
            }
        }
    }

    private void calculateDamage(){
        if(this.temperature>2000){
            this.damage = (int) Math.floor((100.0/4000.0)*(this.temperature-2000.0));
            if(this.damage > 100){
                this.damage = 100;
            }
        }
    }

    private void updateAnimation() {
        if (running) {
        float speed = 0.1f;
        if (damage > 0) {
            speed = 0.1f - 0.0005f * damage;
        }
            if (temperature >= 4000 && temperature <= 6000) {
                hotAnimation.setFrameDuration(speed);
                setAnimation(hotAnimation);
            } else if (temperature > 6000) {
                setAnimation(brokenAnimation);
            } else {
                normalAnimation.setFrameDuration(speed);
                setAnimation(normalAnimation);
            }
        }else{
            if (damage < 100){
                setAnimation(offAnimation);
            }else {
                setAnimation(brokenAnimation);
            }
        }
    }

    public void extinguishWith(FireExtinguisher fireExtinguisher){
        if(fireExtinguisher != null && damage == 100){
            this.temperature = 4000;
            setAnimation(extinguishedAnimation);
        }
    }

    public void repairWith(Hammer hammer){
        if(hammer != null && damage > 0 && damage < 100){
            int oldTemp = temperature;
            if(damage > 50){
                damage = damage - 50;
                this.temperature = (int) Math.floor((4000.0/100.0)*(this.damage)) + 2000;
            }else {
                damage = damage - 50;
                this.temperature = (int) Math.floor((4000.0/100.0)*(this.damage)) + 2000;
                if(this.temperature > oldTemp){
                    this.temperature = oldTemp;
                }
                if(this.temperature < 0){
                   this.temperature = 0;
                }
                damage = 0;
            }
            hammer.use();
            updateAnimation();

        }
    }

    public void turnOn(){
        if(damage < 100) {
            this.running = true;
            updateAnimation();
            if(light != null) {
                this.light.setElectricityFlow(running);
            }
        }
    }

    public void turnOff(){
        this.running = false;
        updateAnimation();
        if(light != null) {
            this.light.setElectricityFlow(running);
        }
    }

    public boolean isRunning(){
        return running;
    }

}
