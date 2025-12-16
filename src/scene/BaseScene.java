package scene;

import game.GameContext;
import gamemaster.GameMaster;

/**
 * 抽象クラス
 * Sceneで毎回用意するフィールド変数とコンストラクタを継承させるためにまとめるクラス
 */
public abstract class BaseScene {
    protected final GameContext ctx;
    protected final GameMaster gm;
    
    /**
     * 継承させるコンストラクタ
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public BaseScene(GameContext ctx) {
        this.ctx = ctx;
        this.gm = ctx.getGm();
    }
}
