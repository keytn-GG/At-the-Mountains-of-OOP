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
    public Character(String name, int hp, int maxHp, int san, int maxSan, int climbSkill, int navigateSkill,
            int biologySkill) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.san = san;
        this.maxSan = maxSan;
        this.climbSkill = climbSkill;
        this.navigateSkill = navigateSkill;
        this.biologySkill = biologySkill;
    }
    
    public void damageHp(int amount) {
    	hp -= amount;
    	
    	if (hp < 0) {
    		hp = 0;
    	}
    }
    
    //  getter / setter
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSan() {
        return san;
    }

    public void setSan(int san) {
        this.san = san;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxSan() {
        return maxSan;
    }

    public int getClimbSkill() {
        return climbSkill;
    }

    public int getNavigateSkill() {
        return navigateSkill;
    }

    public int getBiologySkill() {
        return biologySkill;
    }
}
