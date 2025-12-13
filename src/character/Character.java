package character;

public class Character {
    private final String name;
    private int hp;
    private final int maxHp;
    private int san;
    private final int maxSan;
    private final int climbSkill;
    private final int navigateSkill;
    private final int biologySkill;
    
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
    
    public void showStatus() {
        System.out.println("私のステータスは...");
        System.out.println("---------------------------------");
        System.out.println("HP（体力 / 最大体力） -> " + this.hp + " / " + this.maxHp);
        System.out.println("SAN（正気度 / 最大正気度） -> " + this.san + " / " + this.maxSan);
        System.out.println("技能：登攀（山や崖を上る能力） -> " + this.climbSkill);
        System.out.println("技能：ナビゲート（道に迷わず進む能力） -> " + this.navigateSkill);
        System.out.println("技能：生物学（生き物に関する知識） -> " + this.biologySkill);
        System.out.println("---------------------------------");
    }
}
