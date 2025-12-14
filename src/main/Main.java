package main;

import java.util.Scanner;

import character.Character;
import character.CharacterBuilder;
import character.CharacterSpec;
import character.CharacterUI;
import gamemaster.GameMaster;
import view.CharacterStatusView;

public class Main {
    public static void main(String[] args) {
        // ゲームのユーティリティになるものを準備
        Scanner sc = new Scanner(System.in);
        GameMaster gm = new GameMaster(sc);
        CharacterStatusView statusView = new CharacterStatusView(gm);

        // キャラクターのデータを作る
        CharacterUI ui = new CharacterUI(sc, gm);
        CharacterSpec spec = ui.createSpec();

        // キャラクターを組み立てる
        CharacterBuilder builder = new CharacterBuilder();
        Character player = builder.build(spec);

        statusView.show(player);
    }
}
