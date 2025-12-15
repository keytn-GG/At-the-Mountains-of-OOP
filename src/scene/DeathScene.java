package scene;

import character.Character;
import game.GameContext;
import gamemaster.GameMaster;

public class DeathScene implements Scene {
	private final GameContext ctx;
	private final GameMaster gm;
	private Character player;
	
	public DeathScene(GameContext ctx) {
		this.ctx = ctx;
		this.gm = ctx.getGm();
		this.player = ctx.getPlayer();
	}
	
	@Override
	public Scene play() {
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
		
		return new TitleScene(ctx);
	}
}
