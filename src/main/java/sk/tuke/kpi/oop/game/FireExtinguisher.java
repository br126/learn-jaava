package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.tools.BreakableTool;

public class FireExtinguisher extends BreakableTool {

    public FireExtinguisher(){
        super(1);
        setAnimation(new Animation("sprites/extinguisher.png", 16, 16));
    }
}
