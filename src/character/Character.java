package character;

/**
 * Characterの実体になるクラス
 */
public class Character {
    private final String name;
    private int hp;
    private final int maxHp;
    private int san;
    private final int maxSan;
    private final int climbSkill;
    private final int navigateSkill;
    private final int biologySkill;
    
//    責務分けを検討中
//    private final GameMaster gm = new GameMaster();
    
    /**
     * コンストラクタ
     * @param name 名前
     * @param hp ヒットポイント。0で死亡する。
     * @param maxHp 最大ヒットポイント
     * @param san 正気度。0で廃人になる。
     * @param maxSan 最大正気度
     * @param climbSkill 登攀スキルの成功率
     * @param navigateSkill ナビゲートスキルの成功率
     * @param biologySkill 生物学スキルの成功率
     */
    public Character(String name, int hp, int maxHp, int san, int maxSan, int climbSkill, int navigateSkill, int biologySkill) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.san = san;
        this.maxSan = maxSan;
        this.climbSkill = climbSkill;
        this.navigateSkill = navigateSkill;
        this.biologySkill = biologySkill;
    }
    
//    public void showStatus() {
//        gm.say("君のステータスは...");
//        gm.say("---------------------------------");
//        gm.sayf("HP（体力 / 最大体力） -> %d / %d", this.hp, this.maxHp);
//        gm.sayf("SAN（正気度 / 最大正気度） -> %d / %d", this.san, this.maxSan);
//        gm.sayf("技能：登攀（山や崖を上る能力） -> %d", this.climbSkill);
//        gm.sayf("技能：ナビゲート（道に迷わず進む能力） -> %d", this.navigateSkill);
//        gm.sayf("技能：生物学（生き物に関する知識） -> %d", this.biologySkill);
//        gm.say("---------------------------------");
//    }
}
