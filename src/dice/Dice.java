package dice;

public class Dice {
    private final int COUNT;
    private final int SIDES;

    /**
     * コンストラクタ
     * @param count 振るダイスの数
     * @param sides ダイスの面数
     */
    public Dice(int count, int sides) {
        //  例外を投げる -> throw new エラーの種類
        if (count == 0) {
            throw new IllegalArgumentException("振るダイスの数は1個以上にしてください");
        } else if (sides <= 1) {
            throw new IllegalArgumentException("振るダイスの面数は2以上にしてください");
        }

        // 問題なければ代入
        this.COUNT = count;
        this.SIDES = sides;
        //           ^^^^^ メンバ変数名とコンストラクタの引数名が異なっているので、
        //                 このあとのメソッドでthisを付けなくても区別できるようになる。
    }

    /**
     * ダイスを振るメソッド
     * @return 振ったダイスの数ぶんの出目 -> int
     */
    public int roll() {
        int sum = 0;
        for (int i = 0; i < COUNT; i++) {
            //              ^^^^^ インスタンスが実行するメソッドかつ、コンストラクタ引数と区別できているのでthis.COUNTとする必要はない。
            sum += (int) (Math.random() * SIDES) + 1;
            //            ^^^^^^^^^^^^^ Math.random()の返り値は0.0~1.0なので、少数を整数になおすためにint型にキャスト
            //                          最大値が1足りないので+1
        }
        return sum;
    }
}
