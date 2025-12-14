package scene;

import game.GameContext;
import gamemaster.GameMaster;

/**
 * ゲームの導入部分を表示するシーン
 */
public class IntroScene implements Scene {
    private final GameContext ctx;
    private final GameMaster gm;
    
    /**
     * コンストラクタ
     * @param ctx GameContextを受け取る変数
     */
    public IntroScene(GameContext ctx) {
        this.ctx = ctx;
        this.gm = ctx.getGm();
    }
    
    /**
     * このSceneのplay()
     * 
     */
    public Scene play() {
        return null;
    }
}
