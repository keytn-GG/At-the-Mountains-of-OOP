package character;

public class CharacterSpec {
    private final String name;
    private final int hp;
    private final int san;
    private final int climbSkill;
    private final int navigateSkill;
    private final int biologySkill;

    public CharacterSpec(String name, int hp, int san, int climb, int navigate, int biology) {
        this.name = name;
        this.hp = hp;
        this.san = san;
        this.climbSkill = climb;
        this.navigateSkill = navigate;
        this.biologySkill = biology;
    }

    //    getter / setter
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
