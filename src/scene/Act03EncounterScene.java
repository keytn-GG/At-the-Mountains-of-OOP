package scene;

import character.Character;
import dice.Dice;
import game.GameContext;

public class Act03EncounterScene extends BaseScene implements Scene {
    private Character player;
    
    /**
     * コンストラクタ
     * 継承 + player
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public Act03EncounterScene(GameContext ctx) {
        super(ctx);
        this.player = ctx.getPlayer();
    }
    
    @Override
    public Scene play() {
        gm.say("""
                雪崩から逃れた君は、岩の裂け目へ滑り込むように身を隠した。
                風は遮られ、音だけが遠くで鳴っている。
                """);
        gm.waitEnter();
        
        gm.say("""
                暗い。
                ランプの光が届く範囲だけが、現実として存在している。
                """);
        gm.waitEnter();
        
        gm.say("""
                天井から、雫が落ちる。
                規則的で、落ち着くはずの音だった。
                """);
        gm.waitEnter();
        
        gm.say("""
                だが――その音が、いつの間にか二重になっている。
                """);
        gm.waitEnter();
        
        gm.say("......");
        gm.say("""
                君の背後で。
                もうひとつの“水音”が、遅れて響く。
                """);
        gm.waitEnter();
        
        gm.sayf("「……%s、止まれ」", player.getName());
        gm.waitEnter();
        
        gm.say("""
                隊長だ！生きていたのだ！
                何と幸運なことか！
                
                隊長の声は、かすれていた。
                
                隊長は、ランプを持つ手をゆっくりと上げる。
                """);
        gm.waitEnter();
        
        gm.say("""
                光が、裂け目の奥を照らす。
                """);
        gm.waitEnter();
        
        gm.say("""
                そこに“何か”がいた。
                
                名状しがたい気配に、生存の喜びも消え失せる。
                """);
        gm.waitEnter();
        
        gm.say("""
                それは生き物の形をしていない。
                だが、確かに動いている。
                
                粘性のある影が、壁を這い、床に溜まり、また立ち上がる。
                どこからともなく、泡立つような音がする。
                """);
        gm.waitEnter();
        
        gm.say("""
                君は理解してしまう。
                これは自然現象ではない。
                """);
        gm.waitEnter();
        
        gm.say("そして、これを“見た”という事実は君をとらえて逃がさない。");
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
                    --- それでも理解は避けられない ---
                    --- 正気度を 1D10 失う ---
                    """);
            
            // 変化前の現在値をローカル変数に閉じ込める
            int beforeSan = player.getSan();
            
            // ダメージ決定ロール
            Dice dice = new Dice(1, 10);
            int damage = dice.roll();
            
            // ダメージを与える
            player.damageSan(damage);
            
            // 変化後の現在値をローカル変数に閉じ込める
            int afterSan = player.getSan();
            
            gm.sayf("--- %d の正気度を喪失する ---", damage);
            // 変化前と変化後の値で、差分を表現
            gm.sayf("正気度 %d -> %d", beforeSan, afterSan);
            
            if (player.isInsane()) {
                return new EndingInsaneScene(ctx);
            }
            
            gm.waitEnter();
        } else {
            gm.say("......");
            gm.waitEnter();
            
            gm.sayf("--- %d （あなたの正気度: %d） -> 失敗！ ---", roll, player.getSan());
            gm.waitEnter();
                        
            gm.say("""
                    --- 理性が耐えきれない ---
                    --- 正気度を 1D20 失う ---
                    """);
            
            // 変化前の現在値をローカル変数に閉じ込める
            int beforeSan = player.getSan();
            
            // ダメージ決定ロール
            Dice dice = new Dice(1, 20);
            int damage = dice.roll();
            
            // ダメージを与える
            player.damageSan(damage);
            
            // 変化後の現在値をローカル変数に閉じ込める
            int afterSan = player.getSan();
            
            gm.sayf("--- %d の正気度を喪失する ---", damage);
            // 変化前と変化後の値で、差分を表現
            gm.sayf("正気度 %d -> %d", beforeSan, afterSan);
            
            if (player.isInsane()) {
                return new EndingInsaneScene(ctx);
            }
            
            gm.waitEnter();
        }
        
        gm.say("隊長が、震える息で呟く。");
        gm.waitEnter();
        
        gm.say("""
                「……目を逸らすな」
                「逸らした瞬間に、足が止まる」
                """);
        gm.waitEnter();
        
        gm.say("「止まったら――終わりだ」");
        gm.waitEnter();
        
        gm.say("""
                君の喉が鳴る。
                乾いた音が、裂け目の壁に反射して返ってくる。
                """);
        gm.waitEnter();
        
        gm.say("""
                その瞬間——
                
                “それ”が、止まった。
                """);
        gm.waitEnter();
        
        gm.say("""
                泡立つ音が消える。
                水音も、呼吸も、すべてが一拍だけ沈黙した。
                """);
        gm.waitEnter();
        
        gm.say("そして。");
        gm.say("闇の奥で、何かが“こちらを向いた”気配がした。");
        gm.waitEnter();
        
        gm.say("""
                「……まずい」
                
                隊長の声が、初めて明確に震える。
                """);
        gm.waitEnter();
        
        gm.say("「走れ。今すぐだ」");
        gm.waitEnter();
        
        gm.say("""
                君は反射的に身を翻す。
                足が雪を蹴る。腕が岩を掴む。
                息が凍り、肺が痛い。
                """);
        gm.waitEnter();
        
        gm.say("""
                背後から、粘つく音が追ってくる。
                ぬめりを含んだ“水”のような音。
                だが水ではない。生きている！
                """);
        gm.waitEnter();
        
        gm.say("""
                --- 逃走しろ ---
                --- Enterで続行 ---
                """);
        gm.waitEnter();
        
        gm.say("隊長が叫ぶ。");
        gm.waitEnter();
        
        gm.say("「出口だ！　光の方へ！」");
        gm.waitEnter();
        
        gm.say("""
                裂け目の先に、淡い白が見える。
                空だ。外だ。だが——
                """);
        gm.waitEnter();
        
        gm.say("吹雪と岩壁に阻まれ、下へは戻れない。");
        gm.waitEnter();
        
        gm.say("""
                君の視界に、上へ伸びる稜線が映る。
                光が、わずかに残っている場所。
                """);
        gm.waitEnter();
        
        gm.say("「……上しかない」");
        gm.waitEnter();
        
        gm.say("震える声が口から漏れ出した。");
        gm.say("""
                君の言葉に、隊長は一瞬ためらいを見せたが
                覚悟を決したのか眼光に光が宿る。
                """);
        gm.waitEnter();
        
        gm.say("""
                「太陽の下まで行く」
                「光のある場所なら、まだ——まだ、現実に戻れる」
                """);
        gm.waitEnter();
        
        gm.say("""
                君たちは無我夢中で駆け上がる。
                背後の音は、近い。
                
                決断の時だ。
                """);
        gm.waitEnter();
        
        gm.say("""
                --- 道は一つだ ---
                --- Enterで進む ---
                """);
        gm.waitEnter();
                
        return null;
    }
}
