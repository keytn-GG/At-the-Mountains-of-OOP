package scene;

import character.Character;
import dice.Dice;
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
                足が、言うことをきかない。
                太腿が焼けつくように痛み、肺が悲鳴を上げる。
                
                呼吸のたびに、喉の奥で氷が砕けるような音がする。
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
                眼前には、切り立った岩壁。
                吹雪に削られ、白く凍りついた斜面。
                掴める場所は、ほとんど見えない。
                
                下を見れば、闇と雪。
                戻る道は、もうない。
                """);
        gm.waitEnter();
        
        gm.say("「……登るしかない！」");
        gm.waitEnter();
        
        gm.say("""
                --- 登攀チェックを行います ---
                --- 1D100 <= 登攀スキル で成功 ---
                """);
        gm.waitEnter();

        Dice checkDice = new Dice(1, 100);
        int roll = checkDice.roll();

        if (roll <= player.getClimbSkill()) {
            gm.say("......");
            gm.waitEnter();

            gm.sayf("--- %d （あなたの技能値: %d） 成功！ ---", roll, player.getClimbSkill());
            gm.waitEnter();

            gm.say("""
                    指先が、岩の割れ目にかかる。
                    感覚がない。
                    それでも、力を込める。
                    """);
            gm.waitEnter();
            
            gm.say("""
                    身体を引き上げるたび、筋肉が引き裂かれる。
                    一歩、一歩。
                    滑れば終わりだという事実だけが、思考を支配する。
                    """);
            gm.waitEnter();
        } else {
            gm.say("......");
            gm.waitEnter();

            gm.sayf("--- %d （あなたの技能値: %d） -> 失敗！ ---", roll, player.getClimbSkill());
            gm.waitEnter();

            gm.say("""
                    足が外れ、身体が岩に叩きつけられる。
                    息が詰まり、視界が白く弾けた。
                    """);
            gm.waitEnter();

            gm.say("""
                    --- バランスを失い岩壁に叩きつけられる！ ---
                    --- 1D6 のHPダメージロール ---
                    """);

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
        }
        
        gm.say("君は歯を食いしばり、なおも上を目指す。");
        gm.waitEnter();
        
        gm.say("""
                視界の先に、色がある。
                白でも灰でもない——
                太陽の光だ。
                """);
        gm.waitEnter();
        
        gm.say("""
                だが、距離はまだある。
                腕が震え、指が痺れて、力が抜けていく。
                """);
        gm.waitEnter();
        
        gm.say("下から、音がした。");
        gm.waitEnter();
        
        gm.say("""
                水音。
                泡立つような、不規則な“生きた音”。
                """);
        gm.waitEnter();
        
        gm.say("""
                聞きたくない。
                だが、耳が拒まない。
                
                上だ。
                
                ひたすら上へ。
                
                君は祈りにも似た思いで、鋭い岩に指をかける。
                """);
        gm.waitEnter();
        
        gm.say("""
                --- 最後の登攀チェックを行います ---
                --- 1D100 <= 登攀スキル で成功 ---
                """);
        gm.waitEnter();

        Dice lastCheckDice = new Dice(1, 100);
        int lastRoll = lastCheckDice.roll();

        if (lastRoll <= player.getClimbSkill()) {
            gm.say("......");
            gm.waitEnter();

            gm.sayf("--- %d （あなたの技能値: %d） 成功！ ---", lastRoll, player.getClimbSkill());
            gm.waitEnter();

            gm.say("""
                    最後の力を振り絞り、岩を掴む。
                    爪が割れ、皮膚が裂ける。
                    それでも、離さない。
                    """);
            gm.waitEnter();
        } else {
            gm.say("......");
            gm.waitEnter();

            gm.sayf("--- %d （あなたの技能値: %d） -> 失敗！ ---", lastRoll, player.getClimbSkill());
            gm.waitEnter();

            gm.say("""
                    腕が、限界を迎える。
                    力が抜け、身体が宙に投げ出される。
                    """);
            gm.waitEnter();

            gm.say("""
                    --- かろうじて突き出た岩場にしがみつく ---
                    --- 1D6 のHPダメージロール ---
                    """);

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
                    もし、ここで今体力が尽きれば——
                    君は雪と闇の中へ落ちていく。
                    """);
            gm.waitEnter();
            
            gm.say("あきらめるわけにはいかない！");
            gm.waitEnter();
        }
        
        gm.say("""
                    そして——
                    """);
        gm.waitEnter();
        
        gm.say("""
                君は、ついに稜線へと転がり出た。
                """);
        gm.waitEnter();
        
        gm.say("""
                太陽の光が、視界を満たす。
                眩しさに目を閉じると、熱があることに気づく。
                """);
        gm.waitEnter();
        
        gm.say("""
                生きている。
                確かに、生きている。
                """);
        gm.waitEnter();
        
        gm.say("""
                隊長が、隣で膝をつく。
                
                「……やったな」
                """);
        gm.waitEnter();
        
        gm.say("その声は、かすれているが、笑っていた。");
        gm.waitEnter();
        
        gm.say("""
                だが。
                
                安堵と同時に、胸の奥に冷たいものが残る。
                """);
        gm.waitEnter();
        
        gm.say("""
                ここまで登ってきたはずなのに。
                太陽の下に出たはずなのに。
                """);
        gm.waitEnter();
        
        gm.say("あの“気配”が、完全に消えたとは思えない。");
        gm.waitEnter();
        
        gm.say("""
                山の影の向こう。
                あるいは、記憶の奥底で。
                """);
        gm.waitEnter();
        
        gm.say("“それ”は、まだそこにいる。");
        gm.waitEnter();
        
        gm.say("""
                生還の喜びと、登頂の達成感。
                そして、名状しがたい薄ら寒さ。
                """);
        gm.waitEnter();
        
        gm.say("""
                君は、それらすべてを抱えたまま、
                しばらくの間、空を見上げ続けた。
                """);
        gm.waitEnter();
        
        return null;
    }
}
