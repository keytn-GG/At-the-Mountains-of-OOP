package scene;

import character.Character;
import character.CharacterBuilder;
import character.CharacterSpec;
import character.CharacterUI;

/**
 * キャラクターを作るシーン
 */
public class CharacterCreateScene implements Scene {
    // キャラクターのデータを作る
    CharacterUI ui = new CharacterUI(sc, gm);
    CharacterSpec spec = ui.createSpec();

    // キャラクターを組み立てる
    CharacterBuilder builder = new CharacterBuilder();
    Character player = builder.build(spec);
}
