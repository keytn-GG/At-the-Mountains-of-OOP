package scene;

import character.Character;
import dice.Dice;
import game.GameContext;

/**
 * 第2幕のシーン2
 * 途中でSAN減少イベントあり
 */
public class CampNightScene extends BaseScene implements Scene {
    private Character player;
    
    /**
     * コンストラクタ
     * 継承 + player
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public CampNightScene(GameContext ctx) {
        super(ctx);
        this.player = ctx.getPlayer();
    }
    
    @Override
    public Scene play() {
        gm.say("""
                その夜、調査隊は岩陰に簡易的なキャンプを設営した。
                吹雪は弱まったが、静けさが逆に不安を煽る。
                
                音が、ない。
                風の音すら、遠くに引いている。
                """);
        gm.waitEnter();
        
        gm.say("""
                ランプの光が、岩肌に歪んだ影を落とす。
                影は人の形に似て、しかしどこか決定的に違っていた。
                """);
        gm.waitEnter();
        
        gm.say("""
                「……今、誰か……呼ばなかったか？」
                """);
        gm.waitEnter();
        
        gm.say("""
                問いかけに、返事はない。
                だが、否定する声もなかった。
                """);
        gm.waitEnter();
        
        gm.say("""
                --- 正気度チェックを行います ---
                --- 1D100 <= 現在の正気度 で成功 ---
                """);
        gm.waitEnter();
        
        Dice checkDice = new Dice(1, 100);
        int roll = checkDice.roll();
        
        if (roll <= player.getSan()) {
            gm.say("......");
            gm.waitEnter();
            
            gm.sayf("--- %d （あなたの正気度: %d） 成功！ ---", roll, player.getSan());
            gm.waitEnter();
            
            gm.say("""
                    君は深く息を吐き、視線を逸らす。
                    疲労が、感覚を過敏にしているだけだ。
                    そう自分に言い聞かせる。
                    """);
            gm.waitEnter();
            
            gm.say("""
                    だが、安心は訪れない。
                    ただ、耐えられただけだ。
                    """);
            gm.waitEnter();
        } else {
            gm.say("......");
            gm.waitEnter();
            
            gm.sayf("--- %d （あなたの正気度: %d） -> 失敗！ ---", roll, player.getSan());
            gm.waitEnter();
            
            gm.say("""
                    影が、僅かに動いた気がした。
                    
                    いや――動いたのは、君の認識そのものだ。
                    """);
            gm.waitEnter();
            
            gm.say("""
                    --- 不安が精神を侵食する ---
                    --- 1D3 の正気度ダメージ ---
                    """);
            
            // 変化前の現在値をローカル変数に閉じ込める
            int beforeSan = player.getSan();
            
            // ダメージ決定ロール
            Dice dice = new Dice(1, 3);
            int damage = dice.roll();
            
            // ダメージを与える
            player.damageSan(damage);
            
            // 変化後の現在値をローカル変数に閉じ込める
            int afterSan = player.getSan();
            
            gm.sayf("--- %d の正気度を喪失する ---", damage);
            // 変化前と変化後の値で、差分を表現
            gm.sayf("正気度 %d -> %d", beforeSan, afterSan);
            
            if (player.isInsane()) {
                return new InsaneScene(ctx);
            }
            
            gm.waitEnter();
            
            gm.say("""
                    何かが、確実におかしい。
                    だが、それを言葉にした瞬間、
                    すべてが崩れてしまう気がした。
                    """);
            gm.waitEnter();
        }
        
        gm.say("""
                夜は、ゆっくりと明けていく。
                
                誰も「引き返そう」とは言わなかった。
                言えなかったのかもしれない。
                
                山脈は、すぐそこまで迫っている。
                """);
        gm.waitEnter();
        
        gm.say("""
                --- この恐ろしい山で唯一君たちを照らす希望の光、夜明けだ ---
                --- Enterで進む ---
                """);
        gm.waitEnter();
        
        return null;
    }
}
