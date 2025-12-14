package game;

import java.util.Scanner;

import character.Character;
import gamemaster.GameMaster;

/**
 * ゲーム中、各Sceneに渡されるものをまとめるクラス
 */
public class GameContext {
    private final Scanner sc;
    private final GameMaster gm;
    private Character player;
    
    /**
     * コンストラクタ
     * @param sc Scannerの参照アドレスを受け取る変数
     * @param gm GameMasterのインスタンスを受け取る変数
     */
    public GameContext(Scanner sc, GameMaster gm) {
        this.sc = sc;
        this.gm = gm;
    }
}
