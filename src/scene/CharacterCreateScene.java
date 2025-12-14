package scene;

import character.Character;
import character.CharacterBuilder;
import character.CharacterSpec;
import character.CharacterUI;
import game.GameContext;
import gamemaster.GameMaster;

/**
 * キャラクターを作るシーン
 */
public class CharacterCreateScene implements Scene {
    private final GameContext ctx;
    private final GameMaster gm;

    /**
     * コンストラクタ
     * @param ctx シーンに渡されるデータをまとめたもの -> GameContext
     */
    public CharacterCreateScene(GameContext ctx) {
        this.ctx = ctx;
        this.gm = ctx.getGm();
    }

    /**
     * キャラクターを作るシーン
     * 1. UIにctxのscとgmを渡す
     * 2. 返ってきたSpecを格納
     * 3. Builderをインスタンス化
     * 4. Builderのbuild()に、specを渡す
     * 5. 返ってきたキャラクターを格納
     * 6. キャラクターをctxのplayerに格納
     * 7. 次のシーンにctxを渡しながらインスタンス化する
     */
    public Scene play() {
        // キャラクターのデータを作る
        CharacterUI ui = new CharacterUI(ctx.getSc(), gm);
        CharacterSpec spec = ui.createSpec();

        // キャラクターを組み立てる
        CharacterBuilder builder = new CharacterBuilder();
        Character player = builder.build(spec);

        // 作ったキャラクターをGameContextにセットする
        ctx.setPlayer(player);

        return new StatusViewScene(ctx);
    };
}
