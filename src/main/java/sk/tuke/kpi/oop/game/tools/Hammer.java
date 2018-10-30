package sk.tuke.kpi.oop.game.tools;


import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.tools.BreakableTool;

public class Hammer extends BreakableTool {

    private Animation animation;

    public Hammer(){
        super(1);
        animation = new Animation("sprites/hammer.png", 16, 16);
        setAnimation(animation);
    }

    public Hammer(int numOfUsages){
        super(numOfUsages);

    }
}
