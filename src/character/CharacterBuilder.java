package character;

/**
 * Specを受け取ってCharacterを生成するクラス
 */
public class CharacterBuilder {
    /**
     * Specを受け取って組み立てたインスタンスを返却するメソッド
     * @param spec CharacterSpecで取りまとめたデータを受け取る変数
     * @return Characterのインスタンス
     */
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
