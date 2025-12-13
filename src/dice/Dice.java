package dice;

import java.util.Random;

public class Dice {
    private final int count;
    private final int sides;

    /**
     * コンストラクタ
     * @param count 振るダイスの数
     * @param sides ダイスの面数
     */
    public Dice(int count, int sides) {
        //  例外を投げる -> throw new エラーの種類
        if (count <= 0) {
            throw new IllegalArgumentException("振るダイスの数は1個以上にしてください");
        } else if (sides <= 1) {
            throw new IllegalArgumentException("振るダイスの面数は2以上にしてください");
        }

        // 問題なければ代入
        this.count = count;
        this.sides = sides;
        //           ^^^^^ メンバ変数名とコンストラクタの引数名が異なっているので、
        //                 このあとのメソッドでthisを付けなくても区別できるようになる。
    }

    /**
     * ダイスを振るメソッド
     * @return 振ったダイスの数ぶんの出目 -> int
     */
    public int roll() {
        int sum = 0;
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            sum += rand.nextInt(sides) + 1;
        }
        return sum;
    }
}
