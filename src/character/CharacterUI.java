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
        gm.say("南極大陸、調査隊キャンプ。");
        gm.say("吹雪の合間を縫って、輸送機が着陸する。\n君はここに、最後の補充要員として送り込まれた。");
        gm.waitEnter();
        
        gm.say("テントの前で、隊長と思しき人物が君を迎える。\n年季の入った防寒具と、鋭い眼差しが印象的だ。");
        gm.waitEnter();
        
        gm.say("「君が今回の調査登山隊に参加する、最後のメンバーだな」");
        gm.waitEnter();
        
        gm.say("「長旅ご苦労だった。まずは名前を聞かせてくれ」");
        gm.say("--- 自分の名前を入力しよう ---");
        String name;
        while(true) {
        	name = sc.nextLine().trim();
        	
        	if(!name.isEmpty()) {
        		break;
        	}
        	
        	gm.say("隊長は一瞬、無言で君を見る。");
            gm.waitEnter();
            gm.say("「……聞こえなかった。もう一度頼む」");
            gm.say("--- 自分の名前を入力しよう ---");
        }
        gm.say("隊長は君の名前を一度、頭の中で反芻する。");
        gm.waitEnter();
        gm.sayf("「なるほど……%s、か」", name);
        gm.say("「覚えた。今日から君もこの調査隊の一員だ」");

        // Diceを生成して振ってhpを決定
        gm.say("隊長は君の立ち姿を一瞥し、装備の状態を確かめる。");
        gm.waitEnter();
        gm.say("「南極では、体力がそのまま生死に直結する」");
        gm.say("「見たところ……君の体力は」");
        gm.waitEnter();
        Dice hpDice = new Dice(3, 6);
        int hp = hpDice.roll() + 10;
        gm.sayf("「……%d といったところだな」", hp);
        gm.say("「無理はするな。ここでは、倒れたら終わりだ」");
        gm.waitEnter();

        // Diceを生成して振ってsanを決定
        gm.say("隊長は一瞬、山脈の方角へ視線を向ける。");
        gm.waitEnter();
        gm.say("「この地では、肉体以上に精神が削られる」");
        gm.say("「冷静さを保てるかどうかが、生還の分かれ目だ」");
        gm.waitEnter();
        Dice sanDice = new Dice(3, 6);
        int san = sanDice.roll() * 6;
        gm.sayf("「君の冷静さはおよそ……%d」", san);
        gm.say("「悪くない。だが、油断はするな」");
        gm.waitEnter();

        gm.say("隊長は手元の書類に目を落とし、ペンを走らせる。");
        gm.waitEnter();
        
        gm.say("「次に、君の専門分野を確認する」");
        gm.say("「今回の調査では、以下の三つが特に重要だ」");
        gm.waitEnter();
        
        gm.say("登攀（とうはん） —— 山や崖を越える力");
        gm.say("ナビゲート —— 吹雪の中で進路を見失わない力");
        gm.say("生物学 —— 発見物を正しく理解するための知識");
        gm.waitEnter();
        
        gm.say("「合計で一定の範囲に収まるよう、割り振ってくれ」");
        gm.say("「どれも疎かにはできない」");
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
            
            gm.sayf("--- それぞれ0~%dまで、合計が%dとなるように割り振ろう ---", SKILL_LIMIT, TOTAL);
            gm.waitEnter();

            // 1つ目の技能
            gm.sayf("登攀（0~%d) -> ", SKILL_LIMIT);
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
            gm.sayf("ナビゲート（0~%d） -> ", navigateLimit);
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
            gm.sayf("生物学（残りポイント） -> \n%d", biology);

            while (true) {
            	gm.say("隊長は書類を差し出し、君の顔を見る。");
            	gm.waitEnter();
            	
            	gm.say("「これが、君の能力だ」");
            	gm.say("「間違いはないか？」（y/n）");
                gm.say("---------------------------------");
                gm.sayf("登攀 -> %d", climb);
                gm.sayf("ナビゲート -> %d", navigate);
                gm.sayf("生物学 -> %d", biology);
                gm.say("---------------------------------");

                String res = sc.nextLine().trim();
                //                        ^^^^^^^ String型で使える「スペースなどを取り除く」メソッド」

                if (res.equalsIgnoreCase("y")) {
                    gm.say("隊長は小さく頷く。");
                    gm.waitEnter();
                    
                    gm.say("「よし。これで準備は整った」");
                    gm.say("「後は、実地で証明してもらうだけだ」");
                    gm.waitEnter();
                    
                    return new int[] { climb, navigate, biology };
                } else if (res.equalsIgnoreCase("n")) {
                	gm.say("隊長は無言で書類を引き戻す。");
                	gm.waitEnter();
                	
                	gm.say("「構わん。やり直そう」");
                	gm.say("「納得できる形で来てくれ」");
                    gm.waitEnter();
                    
                    break;
                } else {
                    gm.say("（yかnで答えよう。）");
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
        gm.sayf("--- 各技能は0~%dで、合計が%dの範囲におさめよう ---", limit, total);
        gm.waitEnter();
    }
}
