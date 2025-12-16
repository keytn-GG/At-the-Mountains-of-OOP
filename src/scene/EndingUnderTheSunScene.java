package scene;

import character.Character;
import game.GameContext;

public class EndingUnderTheSunScene extends BaseScene implements Scene {
	private Character player;
	
	/**
	 * コンストラクタ
	 * 継承 + player
	 * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
	 */
	public EndingUnderTheSunScene(GameContext ctx) {
		super(ctx);
		this.player = ctx.getPlayer();
	}
	
	@Override
	public Scene play() {
		gm.say("""
				稜線の向こう側へ下りると、風は嘘のように穏やかだった。
				太陽が、確かにそこにある。
				""");
		gm.waitEnter();
		
		gm.say("""
				光は冷たいが、それでも闇とは違う。
				""");
		gm.waitEnter();
		
		gm.say("""
				調査隊のキャンプが見えたのは、しばらくしてからだった。
				""");
		gm.waitEnter();
		
		gm.say("""
				小さな点のようなテント。
				だが、確かに人の営みの跡だ。
				""");
		gm.waitEnter();
		
		gm.say("""
				「……戻れたな」
				""");
		gm.waitEnter();
		
		gm.say("""
				隊長はそう言って、雪の上に腰を下ろした。
				""");
		gm.waitEnter();
		
		gm.say("""
				その表情には安堵があった。
				だが、それ以上に――
				深い疲労と、言葉にできない何かが滲んでいる。
				""");
		gm.waitEnter();
		
		gm.say("""
				...
				""");
		gm.waitEnter();
		
		gm.say("""
				......
				""");
		gm.waitEnter();
		
		gm.say("""
				後日、君たちは救助隊と合流し、南極を後にした。
				公式記録には、こう残された。
				""");
		gm.waitEnter();
		
		gm.say("""
				「未踏の山脈を確認」
				「地質的に興味深い構造を発見」
				「悪天候のため調査は中断」
				""");
		gm.waitEnter();
		
		gm.say("""
				それ以上のことは、どこにも書かれていない。
				""");
		gm.waitEnter();
		
		gm.say("""
				君は、生きて帰った。
				仲間も、生きている。
				""");
		gm.waitEnter();
		
		gm.say("""
				
				
				――――それだけで十分なはずだった。
				
				""");
		gm.waitEnter();
		
		gm.say("""
				だが、夜になると、夢を見る。
				
				暗い裂け目。
				泡立つ音。
				形を持たない“何か”が、壁を這っている。
				""");
		gm.waitEnter();
		
		gm.say("""
				夢の中で、君は必ず思う。
				""");
		gm.waitEnter();
		
		gm.say("""
				（あれは、まだ――）
				""");
		gm.waitEnter();
		
		gm.say("""
				目を覚ますと、太陽の光が差し込んでいる。
				""");
		gm.waitEnter();
		
		gm.say("""
				現実だ。
				""");
		gm.waitEnter();
		
		gm.say("""
				安全な場所だ。
				""");
		gm.waitEnter();
		
		gm.say("""
				それでも、胸の奥に残る薄ら寒さは消えない。
				""");
		gm.waitEnter();
		
		gm.say("""
				君は知ってしまった。
				
				この世界は、人間の理解の及ばないもので満ちていることを。
				そして、それは今も――
				どこかで、静かに息づいていることを。
				""");
		gm.waitEnter();
		
		gm.say("""
				いつかあれがあの闇から這い出てこないことを祈りながら
				君は今日も空を見上げ、生きている。
				""");
		gm.waitEnter();
				
		gm.say("""
				--- END ---
				""");
		gm.say("""
				A T   T H E   M O U N T A I N S   O F   O O P
					  ---------------------------------
					OOP設計を学ぶ、超圧縮！CoC『狂気の山脈にて』
				""");
		gm.say("遊んでくれてありがとうございました。");
		gm.waitEnter();
		
		return new Act00TitleScene(ctx);
	}
}
