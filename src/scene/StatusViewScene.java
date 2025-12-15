package scene;

import character.Character;
import game.GameContext;
import view.CharacterStatusView;

/**
 * プレーヤーキャラクターのステータスを表示するシーン
 */
public class StatusViewScene implements Scene {
    private final GameContext ctx;
    private final CharacterStatusView view;
    
    /**
     * コンストラクタ
     * @param ctx シーンに渡されるデータをまとめたもの -> GameContext
     */
    public StatusViewScene(GameContext ctx) {
        this.ctx = ctx;
        this.view = new CharacterStatusView(ctx.getGm());
    }
    
    /**
     * このシーンのplay()
     * ctxからplayerを取得して、CharacterStatusViewクラスのshow()を利用する
     * 次のSceneをreturnする -> 直前のシーンに戻る処理を入れる予定
     */
    @Override
    public Scene play() {
        Character player = ctx.getPlayer();
        
        view.show(player);
        ctx.getGm().waitEnter();
        
        return null;
    };
}
