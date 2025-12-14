package view;

import character.Character;
import gamemaster.GameMaster;

public class CharacterStatusView {
    private final GameMaster gm;
    
    public CharacterStatusView(GameMaster gm) {
        this.gm = gm;
    }
    
    public void show(Character c) {
        gm.sayf("%sのステータスは...", c.getName());
        gm.say("---------------------------------");
        gm.sayf("HP（体力 / 最大体力） -> %d / %d", c.getHp(), c.getMaxHp());
        gm.sayf("SAN（正気度 / 最大正気度） -> %d / %d", c.getSan(), c.getMaxSan());
        gm.sayf("技能：登攀（山や崖を上る能力） -> %d", c.getClimbSkill());
        gm.sayf("技能：ナビゲート（道に迷わず進む能力） -> %d", c.getNavigateSkill());
        gm.sayf("技能：生物学（生き物に関する知識） -> %d", c.getBiologySkill());
        gm.say("---------------------------------");
    }
}
