package character;

import java.util.Scanner;

import dice.Dice;
import gamemaster.GameMaster;

/**
 * Characterのデータを入力・決定させるクラス
 */
public class CharacterUI {
    private final Scanner sc;
    private final GameMaster gm;

    /**
     * コンストラクタ
     * @param sc Scannerの参照アドレスを受け取る変数
     * @param gm GameMasterインスタンスを受け取る変数
     */
    public CharacterUI(Scanner sc, GameMaster gm) {
        this.sc = sc;
        this.gm = gm;
    }

    /**
     * キャラクターのスペックを決定するメソッド
     * @return CharacterSpecのインスタンス
     */
    public CharacterSpec createSpec() {
        // Scannerによるnameの決定
        gm.say("君が今回の南極調査隊に参加する最後のメンバーだね。君の名前を教えてくれないか？");
        String name = sc.nextLine();
        gm.sayf("ありがとう。そしてようこそ、%s君。狂気山脈の調査登山隊へ！", name);
        gm.waitEnter();

        // Diceを生成して振ってhpを決定
        gm.say("...そうだな。見たところ君の体力は ");
        Dice hpDice = new Dice(3, 6);
        int hp = hpDice.roll() + 10;
        gm.sayf("%d といったところか", hp);
        gm.waitEnter();

        // Diceを生成して振ってsanを決定
        gm.say("...そして君の冷静さは ");
        Dice sanDice = new Dice(3, 6);
        int san = sanDice.roll() * 6;
        gm.sayf("%d といったところのようだな。", san);
        gm.waitEnter();

        int[] skills = allocateSkillPoints();
        int climb = skills[0];
        int navigate = skills[1];
        int biology = skills[2];

        return new CharacterSpec(name, hp, san, climb, navigate, biology);
    }

    /**
     * 技能値を割り振るメソッド
     * @return 3つの技能の値を格納した配列 -> int[]
     */
    private int[] allocateSkillPoints() {
        final int SKILL_LIMIT = 99;
        final int TOTAL = 150;

        while (true) {
            // ループの中で減っていく、技能の合計上限値
            int remaining = TOTAL;
            gm.sayf("君の【登攀】【ナビゲート】【生物学】それぞれの技量を教えてくれ。（合計で%d）", TOTAL);

            // 1つ目の技能
            gm.sayf("登攀（山や崖を上る能力： 0~%d) -> ", SKILL_LIMIT);
            int climb = sc.nextInt();
            sc.nextLine();
            // ^^^^^^^^^ 改行やスペースなどが次の.nextに入ってしまわないようにする
            if (!checkSkillLimit(climb, SKILL_LIMIT)) {
                checkSkillErrorMessage(SKILL_LIMIT, TOTAL);
                continue;
            }
            remaining -= climb;
            // ^^^^^^ 上限値から入力された分を引いて新しい上限値にする

            // 2つ目の技能
            int navigateLimit = Math.min(SKILL_LIMIT, remaining);
            //                  ^^^^^^^^ SKILL_LIMITと残りの上限値で小さい方を返却する
            gm.sayf("ナビゲート（道に迷わず進む能力: 0~%d） -> ", navigateLimit);
            int navigate = sc.nextInt();
            sc.nextLine();
            if (!checkSkillLimit(navigate, navigateLimit)) {
                //                         ^^^^^^^^^^^^^ 残りの上限値をチェック用に渡す
                checkSkillErrorMessage(SKILL_LIMIT, TOTAL);
                continue;
            }
            remaining -= navigate;

            // 3つめの技能は自動で算定
            int biology = remaining;
            gm.sayf("生物学（生き物に関する知識） -> %d", biology);

            while (true) {
                gm.say("以下の能力だ。間違いないか？（y/n）");
                gm.say("---------------------------------");
                gm.sayf("登攀 -> %d", climb);
                gm.sayf("ナビゲート -> %d", navigate);
                gm.sayf("生物学 -> %d", biology);
                gm.say("---------------------------------");

                String res = sc.nextLine().trim();
                //                        ^^^^^^^ String型で使える「スペースなどを取り除く」メソッド」

                if (res.equalsIgnoreCase("y")) {
                    gm.say("ありがとう。それでは、先に到着しているキャンプ設営組に合流しよう！");
                    return new int[] { climb, navigate, biology };
                } else if (res.equalsIgnoreCase("n")) {
                    gm.sayf("合計が%dとなるようにもう一度教えてくれ。", TOTAL);
                    gm.waitEnter();
                    break;
                } else {
                    gm.say("yかnで答えよう。");
                }
            }

        }
    }

    /**
     * 技能値がレンジの範囲内かどうかをチェックするメソッド
     * @param skillValue 技能値 -> int
     * @param skillLimit レンジの上限値 -> int
     * @return boolean
     */
    private boolean checkSkillLimit(int skillValue, int skillLimit) {
        return (skillValue >= 0 && skillValue <= skillLimit);
    }

    /**
     * 技能値をレンジ内に収めるように促すメッセージ
     * @param limit 技能一つの上限値
     * @param total 全技能の合計上限値
     */
    private void checkSkillErrorMessage(int limit, int total) {
        gm.sayf("各技能は0~%dで、合計が%dの範囲におさめてくれ。もう一度だ。", limit, total);
        gm.waitEnter();
    }
}
