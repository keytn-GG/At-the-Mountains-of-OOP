package character;

public class CharacterBuilder {
    public Character build(CharacterSpec spec) {
        final String name = spec.getName();
        final int hp = spec.getHp();
        final int maxHp = hp;
        final int san = spec.getSan();
        final int maxSan = san;
        final int climb = spec.getClimbSkill();
        final int navigate = spec.getNavigateSkill();
        final int biology = spec.getBiologySkill();
        
        return new Character(name, hp, maxHp, san, maxSan, climb, navigate, biology);
    }
}
