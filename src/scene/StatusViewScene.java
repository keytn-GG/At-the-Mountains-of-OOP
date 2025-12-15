package scene;

import character.Character;
import game.GameContext;
import gamemaster.GameMaster;
import view.CharacterStatusView;

/**
 * プレーヤーキャラクターのステータスを表示するシーン
 */
public class StatusViewScene implements Scene {
    private final GameContext ctx;
    private final GameMaster gm;
    private final CharacterStatusView view;
    
    /**
     * コンストラクタ
     * @param ctx シーンに渡されるデータをまとめたもの -> GameContext
     */
    public StatusViewScene(GameContext ctx) {
        this.ctx = ctx;
        this.gm = ctx.getGm();
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
        
        gm.say("隊長はペンを置き、君の方を向く。");
        gm.say("ランプの明かりが、紙面に記された数値を淡く照らしている。");
        gm.waitEnter();
        
        gm.say("「よし……これが、今の君の状態だ」");
        gm.say("");
        
        view.show(player);
        gm.waitEnter();
        
        gm.say("紙に記された数値は、南極という過酷な土地で");
        gm.say("君がどれだけ生き延びられるかを、無言で語っている。");
        gm.waitEnter();
        
        gm.say("「数値はただの目安に過ぎない」");
        gm.say("「だが……ここでは、その“目安”が命を分ける」");
        gm.waitEnter();
        
        gm.say("「山に入れば、思い通りにはならん」");
        gm.say("「覚悟だけは、今ここで決めておけ」");
        gm.waitEnter();
        
        gm.say("隊長の言葉に身が引き締まる。");
        gm.waitEnter();
        
        gm.say("この名状しがたい過酷な山脈で、体力や精神力が尽きたとき......");
        gm.say("自分の身に何が起きるのか、想像に難くない。");
        gm.waitEnter();
        
        gm.say("——あるいは、想像もできないような何かが起こるのだろうか。");
        
        gm.say("ついに過酷な調査が始まる......");
        gm.waitEnter();
        
        gm.say("--- Enterで出発の準備を進める ---");
        gm.waitEnter();
        
        return new ExpeditionStartScene(ctx);
    };
}
