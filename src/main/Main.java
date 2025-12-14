package main;

import java.util.Scanner;

import game.GameContext;
import gamemaster.GameMaster;
import scene.Scene;
import scene.TitleScene;
//import view.CharacterStatusView;

public class Main {
    public static void main(String[] args) {
        // 入力の準備 -> Scanner
        Scanner sc = new Scanner(System.in);

        // GMの準備 -> GameMaster
        GameMaster gm = new GameMaster(sc);

        // シーンに渡される引数のセットを準備 -> GameContext
        GameContext ctx = new GameContext(sc, gm);

        // 最初のシーンだけインスタンス化。ctxを渡す。
        Scene scene = new TitleScene(ctx);

        // sceneに何も返ってこなくなるまで繰り返す
        while (scene != null) {
            scene = scene.play();
        }
    }
}
