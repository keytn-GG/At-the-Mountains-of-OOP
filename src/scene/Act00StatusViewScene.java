package scene;

import character.Character;
import game.GameContext;
import view.CharacterStatusView;

/**
 * 確定したプレイヤーキャラクターの能力値を確認するシーン
 */
public class Act00StatusViewScene extends BaseScene implements Scene {
    private final CharacterStatusView view;
    
    /**
     * コンストラクタ
     * 継承 + CharacterStatusView
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public Act00StatusViewScene(GameContext ctx) {
        super(ctx);
        this.view = new CharacterStatusView(ctx.getGm());
    }
    
    /**
     * このシーンのplay()
     * テキストのみ
     */
    @Override
    public Scene play() {
        Character player = ctx.getPlayer();
        
        gm.say("隊長はペンを置き、君の方を向く。");
        gm.say("ランプの明かりが、紙面に記された数値を淡く照らしている。");
        gm.waitEnter();
        
        gm.say("「よし……これが、今の君の状態だ」");
        gm.say("");
        
        view.show(player); // ここでステータス確認
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
        
        gm.say("この名状しがたい雰囲気をたたえた過酷な山脈で、体力や精神力が尽きたとき......");
        gm.say("自分の身に何が起きるのか、想像に難くない。");
        gm.waitEnter();
        
        gm.say("——あるいは、想像もできないような何かが起こるのだろうか。");
        gm.waitEnter();
        
        gm.say("ついに過酷な調査が始まる......");
        gm.waitEnter();
        
        gm.say("--- Enterで出発の準備を進める ---");
        gm.waitEnter();
        
        return new Act01ExpeditionStartScene(ctx);
    };
}
