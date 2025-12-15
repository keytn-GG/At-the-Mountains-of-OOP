package scene;

import character.Character;
import game.GameContext;

public class Act03PeakAttackScene extends BaseScene implements Scene {
    private Character player;
    
    /**
     * コンストラクタ
     * 継承 + player
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public Act03PeakAttackScene(GameContext ctx) {
        super(ctx);
        this.player = ctx.getPlayer();
    }
    
    @Override
    public Scene play() {
        gm.say("""
                息が切れる。
                肺が凍りつき、視界の端が暗く滲む。
                """);
        gm.waitEnter();
        
        gm.say("""
                背後では、まだ“それ”の気配が消えない。
                直接追ってきてはいない。
                だが、追われているという確信だけが、足を止めさせない。
                """);
        gm.waitEnter();
        
        gm.say("隊長が振り返り、叫ぶ。");
        gm.waitEnter();
        
        gm.say("""
                「止まるな！」
                「ここを越えれば、稜線だ！」
                """);
        gm.waitEnter();
        
        gm.say("""
                眼前には、切り立った斜面。
                吹雪で岩肌は凍りつき、まともな足場は見当たらない。
                
                下へ戻る道は、すでに失われている。
                """);
        gm.waitEnter();
        
        gm.say("「……登るしかない！」");
        
        return null;
    }
}
