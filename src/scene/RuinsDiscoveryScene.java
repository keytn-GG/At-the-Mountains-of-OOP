package scene;

import character.Character;
import dice.Dice;
import game.GameContext;

/**
 * 第2幕：異常の発見シーン
 * SAN減少イベントあり
 */
public class RuinsDiscoveryScene extends BaseScene implements Scene {
	private Character player;
	
	/**
	 * コンストラクタ
	 * 継承 + player
	 * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
	 */
	public RuinsDiscoveryScene(GameContext ctx) {
		super(ctx);
		this.player = ctx.getPlayer();
	}
	
	/**
	 * このシーンのplay()
	 * 途中でSAN減少イベント
	 * SANが 0 になった場合に廃人エンディングに分岐
	 */
	@Override
	public Scene play() {
		gm.say("""
				~~~~~~~~~~~~~~~~~~~~~~~
				 第 2 幕 ： 異 常 の 発 見
				~~~~~~~~~~~~~~~~~~~~~~~
				""");
		gm.say("");
		gm.say("君たち調査隊は、無限に続くかのような難所を必死で越え続けた。");
		gm.waitEnter();
		
		gm.say("顔をあげ、あたりを見渡すとここは少し開けている。ありがたい！休めそうだ、そう思った時");
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
			
			gm.sayf("--- %d （あなたの技能値: %d） 成功！ ---", roll, player.getBiologySkill());
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
			gm.waitEnter();
		} else {
		    gm.say("......");
            gm.waitEnter();
            
            gm.sayf("--- %d （あなたの技能値: %d） -> 失敗！ ---", roll, player.getBiologySkill());
            gm.waitEnter();
            
            gm.say("""
                    模様を見つめた瞬間、
                    頭の奥で何かが軋んだ。
                    
                    目の前の形が、
                    意味を持って“繋がろう”とする。
                    """);
            gm.waitEnter();
            
            gm.say("""
                    --- 理解不能 ---
                    --- 1D6 のSANダメージロール ---
                    """);
            
            Dice dice = new Dice(1, 6);
            int damage = dice.roll();
            
            gm.sayf("--- %d の正気度を喪失する ---", damage);
            player.damageSan(damage);
            gm.sayf("SAN %d -> %d", player.getMaxSan(), player.getSan());
            
            if (player.isInsane()) {
                return new InsaneScene(ctx);
            }
            
            gm.waitEnter();
            
            gm.say("""
                    説明のつかない恐怖が、胸を締め付ける。
                    それは未知への恐怖ではない。
                    
                    “理解しかけた”ことへの拒絶だった。
                    """);
            gm.waitEnter();
		}
		
		gm.say("""
		        吹雪が、再び視界を覆う。
		        
		        遺構は、何事もなかったかのように
		        雪の中へと姿を隠した。
		        
		        だが、見てしまったものは消えない。
		        """);
		gm.waitEnter();
		
        gm.say("--- Enterでさらに山奥へ進む ---");
        gm.waitEnter();
		
		return null;
	}
}
