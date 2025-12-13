package main;

import java.util.Scanner;

import character.Character;
import character.CharacterBuilder;
import character.CharacterSpec;
import character.CharacterUI;
import gamemaster.GameMaster;

public class Main {
    public static void main(String[] args) {
        // ScannerとGameMasterを準備
        Scanner sc = new Scanner(System.in);
        GameMaster gm = new GameMaster(sc);

        // キャラクターのデータを作る
        CharacterUI ui = new CharacterUI(sc, gm);
        CharacterSpec spec = ui.createSpec();

        // キャラクターを組み立てる
        CharacterBuilder builder = new CharacterBuilder();
        Character player = builder.build(spec);

//        player.showStatus();
    }
}
