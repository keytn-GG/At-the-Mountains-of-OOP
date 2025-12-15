package scene;

import character.Character;
import dice.Dice;
import game.GameContext;

/**
 * 第3幕のシーン1
 * HP減少イベントあり
 */
public class Act03AvalancheScene extends BaseScene implements Scene {
    private Character player;
    
    /**
     * コンストラクタ
     * 継承 + player
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public Act03AvalancheScene(GameContext ctx) {
        super(ctx);
        this.player = ctx.getPlayer();
    }
    
    @Override
    public Scene play() {
        gm.say("""
                ~~~~~~~~~~~~~~~~~~~~~~~
                最 終 幕 ： ピ ー ク ア タ ッ ク
                ~~~~~~~~~~~~~~~~~~~~~~~
                """);
        gm.say("");
        gm.say("""
                山の空気が、ふいに張りつめる。
                ついさっきまで唸っていた風が止み、あたりは不気味な静寂に包まれた。
                
                雪を踏みしめる音だけが、やけに大きく響く。
                """);
        gm.waitEnter();
        
        gm.say("（……おかしい）");
        gm.waitEnter();
        
        gm.say("その瞬間だった。");
        gm.say("""
                地鳴りのような低い音が、足元から伝わってくる。
                視界の端で、斜面がゆっくりと――そして一気に崩れた。
                
                雪崩だ！
                """);
        gm.waitEnter();
        
        gm.say("""
                白い壁が、逃げ場を塞ぐように迫ってくる。
                轟音。衝撃。
                身体が宙に浮き、叩きつけられる感覚。
                """);
        gm.waitEnter();
        
        gm.say("--- 1D6 のHPダメージロール ---");
        
        // 変化前の現在値をローカル変数に閉じ込める
        int beforeHp = player.getHp();

        // ダメージ決定ロール
        Dice damageDice = new Dice(1, 6);
        int damage = damageDice.roll();

        // ダメージを与える
        player.damageHp(damage);

        // 変化後の現在値をローカル変数に閉じ込める
        int afterHp = player.getHp();

        gm.sayf("--- %d のダメージを受ける ---", damage);
        // 変化前と変化後の値で、差分を表現
        gm.sayf("HP %d -> %d", beforeHp, afterHp);

        if (player.isDead()) {
            return new EndingDeathScene(ctx);
        }
        
        gm.waitEnter();
        
        gm.say("""
                雪の中に埋もれ、息が詰まる。
                視界は白に閉ざされ、上下の感覚さえ失われる。
                """);
        gm.waitEnter();
        
        gm.say("（……まだ、生きているか？）");
        gm.waitEnter();
        
        gm.say("""
                必死に腕を動かし、雪をかき分ける。
                肺に流れ込む冷気が、痛みとともに意識を引き戻した。
                """);
        gm.waitEnter();
        
        gm.say("""
                やがて、音が遠のく。
                崩れ落ちた雪は静まり、山は再び沈黙を取り戻した。
                """);
        gm.waitEnter();
        
        gm.say("君は雪の中から這い出し、荒く息をつく。");
        gm.say("""
                助かった。
                ――少なくとも、今は。
                """);
        gm.waitEnter();
        gm.say("""
                部隊は散り散りになってしまったようだ。
                こうなってしまっては...
                
                ...いや、待て
                """);
        gm.waitEnter();
        
        gm.say("""
                だが、この場所は明らかにおかしい。
                太陽の光は、もはや山陰に完全に遮られていた。
                """);
        gm.waitEnter();
        
        gm.say("""
                この先で、何が待っているのか。
                それを考える暇もなく、君は視線の先に“それ”を見ることになる。
                """);
        gm.waitEnter();
        
        return new Act03EncounterScene(ctx);
    }
}
