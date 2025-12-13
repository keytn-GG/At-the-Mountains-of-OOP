package character;

/**
 * UIから確定した値を保持するクラス
 */
public class CharacterSpec {
    private final String name;
    private final int hp;
    private final int san;
    private final int climbSkill;
    private final int navigateSkill;
    private final int biologySkill;

    /**
     * コンストラクタ
     * @param name
     * @param hp
     * @param san
     * @param climb
     * @param navigate
     * @param biology
     */
    public CharacterSpec(String name, int hp, int san, int climb, int navigate, int biology) {
        this.name = name;
        this.hp = hp;
        this.san = san;
        this.climbSkill = climb;
        this.navigateSkill = navigate;
        this.biologySkill = biology;
    }

    // getter / setter
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getSan() {
        return san;
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
