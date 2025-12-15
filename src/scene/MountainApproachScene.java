package scene;

import character.Character;
import dice.Dice;
import game.GameContext;

/**
 * 第1幕のシーン2
 * HP減少イベントあり
 */
public class MountainApproachScene extends BaseScene implements Scene {
    private Character player;

    /**
     * コンストラクタ
     * 継承 + player
     * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
     */
    public MountainApproachScene(GameContext ctx) {
        super(ctx);
        this.player = ctx.getPlayer();
    }

    /**
     * このシーンのplay()
     * 途中でHP減少イベント
     * HPが 0 になった場合に死亡エンディングに分岐
     */
    @Override
    public Scene play() {
        gm.say("""
                調査隊は、山脈の麓に差し掛かった。
                なだらかな雪原は終わりを告げ、氷と岩が剥き出しになった斜面が現れる。
                """);
        gm.waitEnter();

        gm.say("""
                「ここからは、登攀になる」
                「足を滑らせれば、下まで一直線だ」
                """);
        gm.waitEnter();

        gm.say("""
                吹雪に削られた岩肌は、氷の刃のように鋭い。
                ロープを張り、慎重に進まなければならない。
                """);
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
                    君は慎重に足場を選び、岩に体を預けながら登っていく。
                    冷たい風に煽られながらも、確実に高度を稼いでいった。
                    """);
            gm.waitEnter();

            gm.sayf("""
                    「%s、いい動きだ」
                    「その調子で行け」
                    """, player.getName());
            gm.waitEnter();
        } else {
            gm.say("......");
            gm.waitEnter();

            gm.sayf("--- %d （あなたの技能値: %d） -> 失敗！ ---", roll, player.getClimbSkill());
            gm.waitEnter();

            gm.say("""
                    足をかけた岩が、鈍い音を立てて崩れた。
                    次の瞬間、体が大きく前に持っていかれる。
                    """);
            gm.waitEnter();

            gm.say("""
                    --- 転倒！ ---
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
                return new DeathScene(ctx);
            }

            gm.waitEnter();

            gm.sayf("""
                    「くそ……%s、無事か！？」
                    「無理をするな、次は確実に行け」
                    """, player.getName());
            gm.waitEnter();
        }

        gm.say("""
                君は落ち着いて体勢を立て直す。
                山は、まだ始まったばかりだ。
                """);
        gm.waitEnter();

        gm.say("""
                --- 人の侵入を拒むかのような山に、君たちは奮い立つ ---
                --- Enterでさらに山奥へ進む ---
                """);
        gm.waitEnter();

        return new RuinsDiscoveryScene(ctx);
    }
}
