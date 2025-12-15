package scene;

import character.Character;
import game.GameContext;
import gamemaster.GameMaster;

public class ExpeditionStartScene implements Scene {
	private final GameContext ctx;
	private final GameMaster gm;
	private Character player;
	
	public ExpeditionStartScene(GameContext ctx) {
		this.ctx = ctx;
		this.gm = ctx.getGm();
		this.player = ctx.getPlayer();
	}
	
	public Scene play() {
		gm.say("""
				~~~~~~~~~~~~~~~~~~~~~~~
				  第 1 幕 ： 調 査 開 始
				~~~~~~~~~~~~~~~~~~~~~~~
				""");
		gm.say("");
		gm.say("""
				調査隊は夜明け前に動き出した。
				凍りついた大地の上を、風が低く唸っている。
				""");
		gm.waitEnter();
		
		gm.say("""
				遠くには、白一色の地平線の向こうに
				異様なほど切り立った山脈が連なっていた。
				""");
		gm.waitEnter();
		
		gm.say("""
				「見えるだろう」
				「あれが、我々の目的地だ」
				""");
		gm.waitEnter();
		
		gm.say("""
				地図に描かれた等高線は、異常な密度で折り重なっている。
				人の足で踏み入ることを、初めから拒んでいるかのようだ。
				""");
		gm.waitEnter();
		
		gm.say("""
				「これより先は、未踏領域になる」
				「天候、地形、何もかもが予測できん」
				""");
		gm.waitEnter();
		
		gm.say("--- これからの行動によって、HPやSANが変動する可能性があります ---");
		gm.waitEnter();
		
		gm.say("""
				吹き荒れる風が、防寒具の隙間から体温を奪っていく。
				何もしていなくとも、体力が削られていく感覚があった。
				""");
		gm.waitEnter();
		
		gm.say("""
				「無理をすれば、体が先に音を上げる」
				「冷静さを失えば……戻っては来られん」
				""");
		gm.waitEnter();
		
		gm.say("""
				調査隊は、無言のまま歩き出す。
				足音だけが、雪原に吸い込まれていった。
				""");
		gm.waitEnter();
		
		return new MountainApproachScene(ctx);
	}
}
