package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class SmartCooler extends Cooler {

    public SmartCooler(Reactor reactor){
        super(reactor);
    }
    @Override
    protected void coolReactor(){
        int temperature = reactor.getTemperature();
        if(temperature > 1500 && temperature < 2500){
            super.coolReactor();
        }
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        //new Invoke(this::coolReactor).scheduleOn(this);
        //coolReactor();
        new Loop<>(new Invoke(this::coolReactor)).scheduleOn(this);
    }

}
