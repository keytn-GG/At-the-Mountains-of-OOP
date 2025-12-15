package scene;

import character.Character;
import dice.Dice;
import game.GameContext;

public class RuinsDiscoveryScene extends BaseScene implements Scene {
	private Character player;
	
	public RuinsDiscoveryScene(GameContext ctx) {
		super(ctx);
		this.player = ctx.getPlayer();
	}
	
	public Scene play() {
		gm.say("""
				~~~~~~~~~~~~~~~~~~~~~~~
				 第 2 幕 ： 異 常 の 発 見
				~~~~~~~~~~~~~~~~~~~~~~~
				""");
		gm.say("");
		gm.say("君たち調査隊は、無限に続くかのような難所を必死で越え続けた。");
		gm.waitEnter();
		
		gm.say("ここは少し開けている。ありがたい！休めそうだ、そう思った時");
		gm.waitEnter();
		
		gm.say("""
				吹雪が一瞬、弱まった。
				
				その隙間から、雪に半ば埋もれた
				不自然な輪郭が姿を現す。
				""");
		gm.waitEnter();
		
		gm.say("""
				岩ではない。
				だが、自然の形とも言い難い。
				
				直線と曲線が混ざり合い、
				人のために作られたとは思えない "構造" が、
				確かにそこに存在していた。
				""");
		gm.waitEnter();
		
		gm.say("「……待て」");
		gm.waitEnter();
		
		gm.say("呆然としていた自分の精神が、隊長の警戒をはらんだ声で現実に引き戻された。");
		gm.waitEnter();
		
		gm.say("""
				「これは、地図には載っていない」
				「そもそも、記録が存在しないはずだ。調べた方がいいかもしれないな...」
				""");
		gm.waitEnter();
		
		gm.say("""
				雪を払うと、表面に刻まれた模様が露わになる。
				それは文字のようでもあり、
				生物の器官の配置にも似ていた。
				""");
		gm.waitEnter();
		
		gm.say("""
				--- 生物学チェックを行います ---
				--- 1D100 <= 生物学スキル で成功 ---
				""");
		gm.waitEnter();
		
		Dice checkDice = new Dice(1, 100);
		int roll = checkDice.roll();
		
		if (roll <= player.getBiologySkill()) {
			gm.say("......");
			gm.waitEnter();
			
			gm.sayf("--- %d 成功！ ---", roll);
			gm.waitEnter();
			
			gm.say("""
					君は、その形状に既視感を覚える。
					既存の生物分類には当てはまらないが、
					「生き物」としての構造原理は、理解できてしまう。
					""");
			gm.waitEnter();
			
			gm.say("""
					これは建造物ではない。
					少なくとも、完全に無機物ではない。
					""");
			gm.waitEnter();
			
			gm.say("""
					理解できてしまった事実が、
					かえって不安を呼び起こす。
					""");
			gm.waitEnter();
			
			gm.say("""
				「……生物、なのか？」
				「いや……そんなはずは……」
					""");
		} else {}
		
		return null;
	}
}
