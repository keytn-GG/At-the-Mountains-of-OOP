package scene;

import game.GameContext;
import gamemaster.GameMaster;

public abstract class BaseScene {
    protected final GameContext ctx;
    protected final GameMaster gm;
    
    public BaseScene(GameContext ctx) {
        this.ctx = ctx;
        this.gm = ctx.getGm();
    }
}
