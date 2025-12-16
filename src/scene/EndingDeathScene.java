package scene;

import character.Character;
import game.GameContext;

/**
 * 死亡エンディングシーン
 */
public class EndingDeathScene extends BaseScene implements Scene {
	private Character player;
	
	/**
	 * コンストラクタ
	 * 継承 + player
	 * @param ctx GameContext（Scannerとゲームマスターのインスタンスをまとめたもの）を受け取る
	 */
	public EndingDeathScene(GameContext ctx) {
	    super(ctx);
		this.player = ctx.getPlayer();
	}
	
	/**
	 * このシーンのplay()
	 * HPが 0 になって死亡した場合のシーン
	 */
	@Override
	public Scene play() {
	    gm.say("...");
	    gm.waitEnter();
	    
	    gm.say("......");
	    gm.waitEnter();
	    
		gm.say("""
				風が鳴っている。
				あるいは、それはただの音ではなく、
				この白い大地そのものが立てる、低い唸り声なのかもしれない。
				
				
				君の視界はゆっくりと狭まり、
				吐く息だけが、暗闇の中で白く溶けた。
				
				
				誰かの声がした気がする。
				だが、その言葉はもう輪郭を持たない。
				
				
				ここでは、倒れた者を長く待つ余裕はない。
				寒さと吹雪は公平で、例外を許さない。
				""");
		gm.waitEnter();
		
		gm.say("""
		        調査隊の記録には、ひとつの行が追加される。
		        名と、日付と、そして短い注釈だけが残る。
		        
		        
		        ――任務続行。
		        
		        
		        君が何を見て、何を感じ、何を恐れたのか。
		        それを語る者は、もういない。
		        """);
		gm.waitEnter();
		
		gm.say("""
				--- あなたは死亡した ---
				--- Enterでタイトルへ戻る ---
				""");
		gm.waitEnter();
		
		return new Act00TitleScene(ctx);
	}
}
