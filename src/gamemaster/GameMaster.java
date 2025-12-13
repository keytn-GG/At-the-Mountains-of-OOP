package gamemaster;

public class GameMaster {
    /**
     * 単純な文字列を表示する
     * @param msg 表示したい文字列やメッセージ
     */
    public void say(String msg) {
        System.out.println(msg);
    }
    
    /**
     * 変数をいくつでも使用して文字列を表示する
     * @param msg 表示したい文字列やメッセージ
     * @param args 文字列に埋め込む変数（複数可）
     * 
     * <p>例： gm.sayf("私の名前は%sです", name);</p>
     * <p>結果: 私の名前は矢田です</p>
     * <ul>
     *  <li>%s -> String</li>
     *  <li>%d -> int</li>
     *  <li>%f -> double</li>
     * </ul>
     */
    public void sayf(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
