package scene;

import character.Character;
import game.GameContext;
import view.CharacterStatusView;

public class StatusViewScene implements Scene {
    private final GameContext ctx;
    private final CharacterStatusView view;
    
    public StatusViewScene(GameContext ctx) {
        this.ctx = ctx;
        this.view = new CharacterStatusView(ctx.getGm());
    }
    
    public Scene play() {
        Character player = ctx.getPlayer();
        
        view.show(player);
        ctx.getGm().waitEnter();
        
        return null;
    };
}
