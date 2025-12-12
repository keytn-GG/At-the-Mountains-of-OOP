package character;

import java.util.Scanner;

import dice.Dice;

public class CharacterUI {
    private final Scanner sc;
    
    /**
     * コンストラクタ
     * @param SC Scannerの参照アドレスを受け取る変数
     */
    public CharacterUI(Scanner sc) {
        this.sc = sc;
    }
    
//    CharacterSpec型の値を返すメソッド
    public CharacterSpec createSpec() {
//        Scannerによるnameの決定
        System.out.println("君が今回の南極調査隊に参加する最後のメンバーだね。君の名前を教えてくれないか？");
        String name = sc.nextLine();
        System.out.println("ありがとう。そしてようこそ、" + name + "君。狂気山脈の調査登山隊へ！");
        
//        Diceを生成して振ってhpを決定
        System.out.print("...そうだな。見たところ君の体力は ");
        Dice hpDice = new Dice(3, 6);
        int hp = hpDice.roll() + 10;
        System.out.print(hp + " といったところか");
        
//        Diceを生成して振ってsanを決定
        System.out.print("...そして君の冷静さは ");
        Dice sanDice = new Dice(3, 6);
        int san = sanDice.roll() * 4;
        System.out.print(san + " といったところのようだな。");
        
        int[] skills = allocateSkillPoints();
        int climb = skills[0];
        int navigate = skills[1];
        int biology = skills[2];
        
        return new CharacterSpec(name, hp, san, climb, navigate, biology);
    }
    
    private int[] allocateSkillPoints() {
        final int TOTAL = 150;
        
        while (true) {
            System.out.println("君の【登攀】【ナビゲート】【生物学】それぞれの技量を教えてくれ。（合計で150）");
            
            System.out.print("登攀（山や崖などを上る能力） -> ");
            int climb = sc.nextInt();
            
            System.out.print("ナビゲート（道に迷わず進む能力） -> ");
            int navigate = sc.nextInt();
            
            int biology = TOTAL - (climb + navigate);
            System.out.println("生物学（生き物に関する知識） -> " + biology);
            
            int total = climb + navigate + biology;
            
            if (total != TOTAL) {
                System.out.println("合計が" + total + "だ。合計が" + TOTAL + "となるように教えてくれないか？");
                continue;
            }
            
            while (true) {
                System.out.println("以下の能力だ。間違いないか？（y/n）");
                System.out.println("---------------------------------");
                System.out.println("登攀 -> " + climb);
                System.out.println("ナビゲート -> " + navigate);
                System.out.println("生物学 -> " + biology);
                System.out.println("---------------------------------");
                
                String res = sc.next().trim();
                
                if (res.equalsIgnoreCase("y")) {
                    System.out.println("");
                    return new int[] {climb, navigate, biology};
                } else if (res.equalsIgnoreCase("n")) {
                    System.out.println("合計が" + TOTAL + "となるように考え直そう。");
                    break;
                } else {
                    System.out.println("yかnで答えよう。");
                }
            }
            
        }
        
    }
}
