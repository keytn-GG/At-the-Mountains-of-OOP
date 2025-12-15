package scene;

import character.Character;
import game.GameContext;
import gamemaster.GameMaster;

public class InsaneScene implements Scene {
	private final GameContext ctx;
	private final GameMaster gm;
	private Character player;
	
	public InsaneScene(GameContext ctx) {
		this.ctx = ctx;
		this.gm = ctx.getGm();
		this.player = ctx.getPlayer();
	}
	
	public Scene play() {
		gm.say("""
				それは、音から始まった。
				
				風の唸りに紛れて、
				意味のあるようで意味のない響きが混ざる。
				次第にそれは、言葉の形を取りはじめた。
				
				君は耳を塞いだ。
				だが、音は外からではなく、
				内側から鳴っていることに気づく。
				
				視界の端で、雪原の白が歪む。
				山脈の輪郭が、あり得ない角度で折れ曲がる。
				空が、遠近を失う。
				
				理解してはいけないものを、
				理解してしまったのだと――
				君は、静かに確信する。
				
				やがて、恐怖すらも薄れていく。
				代わりに残ったのは、奇妙な安堵だった。
				すべてが“正しい位置”に戻ったような感覚。
				
				誰かが君の名を呼ぶ。
				君は返事をしようとして、口を開く。
				
				しかし出てきたのは言葉ではなく、
				笑いとも嗚咽ともつかない息だけだった。
				
				調査隊の記録には、こう残される。
				
				「生還」
				「ただし、本人は語らず」
				
				君が見たものは、語られない。
				君自身もまた、語ることを許されない。
				""");
		gm.waitEnter();
		
		gm.say("""
				--- あなたは正気を失った ---
				--- Enterでタイトルへ戻る ---
				""");
		gm.waitEnter();
		
		return new TitleScene(ctx);
	}
}
