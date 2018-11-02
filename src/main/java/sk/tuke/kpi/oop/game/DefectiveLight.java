package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

import java.util.Random;

public class DefectiveLight extends Light {

    private Random rand;
    private int randInt;

    public DefectiveLight(){
        rand = new Random();
        randInt = 0;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        //new Invoke(this::coolReactor).scheduleOn(this);
        //coolReactor();
        new Loop<>(new Invoke(this::simulateDefectiveLight)).scheduleOn(this);

    }

    private void simulateDefectiveLight(){
        randInt = rand.nextInt(20);
        if (randInt == 10){
            this.toggle();
        }
    }


}
