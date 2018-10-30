package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Reactor;

public class PerpetualReactorHeating extends AbstractAction<Reactor> {

    private int increaseTemp;

    public PerpetualReactorHeating(int increaseTemp){
        this.increaseTemp = increaseTemp;
    }



    public void execute(float deltaTime){
        getActor().increaseTemperature(increaseTemp);
    }

}
