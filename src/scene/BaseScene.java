package scene;

import game.GameContext;
import gamemaster.GameMaster;

public abstract class BaseScene {
    private final GameContext ctx;
    private final GameMaster gm;
    
    public BaseScene(GameContext ctx) {
        this.ctx = ctx;
        this.gm = ctx.getGm();
    }
}
