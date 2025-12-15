package scene;

import character.Character;
import character.CharacterBuilder;
import character.CharacterSpec;
import character.CharacterUI;
import game.GameContext;

/**
 * キャラクターを作るシーン
 */
public class Act00CharacterCreateScene extends BaseScene implements Scene {
    /**
     * コンストラクタ
     * 継承のみ
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public Act00CharacterCreateScene(GameContext ctx) {
        super(ctx);
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
    @Override
    public Scene play() {
        gm.say("""
                ~~~~~~~~~~~~~~~~~~~~~~~
                    調 査 隊 キ ャ ン プ
                ~~~~~~~~~~~~~~~~~~~~~~~
                """);
        gm.say("");
        gm.waitEnter();
        
        // キャラクターのデータを作る
        CharacterUI ui = new CharacterUI(ctx.getSc(), gm);
        CharacterSpec spec = ui.createSpec();

        // キャラクターを組み立てる
        CharacterBuilder builder = new CharacterBuilder();
        Character player = builder.build(spec);

        // 作ったキャラクターをGameContextにセットする
        ctx.setPlayer(player);

        return new Act00StatusViewScene(ctx);
    };
}
