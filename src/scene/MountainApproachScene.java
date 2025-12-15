package scene;

import character.Character;
import dice.Dice;
import game.GameContext;

public class MountainApproachScene extends BaseScene implements Scene {
	private Character player;
	
	public MountainApproachScene(GameContext ctx) {
		super(ctx);
		this.player = ctx.getPlayer();
	}
	
	public Scene play() {
		gm.say("""
				調査隊は、山脈の麓に差し掛かった。
				なだらかな雪原は終わりを告げ、氷と岩が剥き出しになった斜面が現れる。
				""");
		gm.waitEnter();
		
		gm.say("""
				「ここからは、登攀になる」
				「足を滑らせれば、下まで一直線だ」
				""");
		gm.waitEnter();
		
		gm.say("""
				吹雪に削られた岩肌は、氷の刃のように鋭い。
				ロープを張り、慎重に進まなければならない。
				""");
		gm.waitEnter();
		
		gm.say("""
				--- 登攀チェックを行います ---
				--- 1D100 <= 登攀スキル で成功 ---
				""");
		gm.waitEnter();
		
		Dice checkDice = new Dice(1, 100);
		int roll = checkDice.roll();
		
		if (roll <= player.getClimbSkill()) {
			gm.say("......");
			gm.waitEnter();
			
			gm.sayf("--- %d 成功！ ---", roll);
			gm.waitEnter();
			
			gm.say("""
					君は慎重に足場を選び、岩に体を預けながら登っていく。
					冷たい風に煽られながらも、確実に高度を稼いでいった。
					""");
			gm.waitEnter();
			
			gm.say("""
					「いい動きだ」
					「その調子で行け」
					""");
		} else {
			gm.say("......");
			gm.waitEnter();
			
			gm.sayf("--- %d -> 失敗！ ---", roll);
			gm.waitEnter();
			
			gm.say("""
					足をかけた岩が、鈍い音を立てて崩れた。
					次の瞬間、体が大きく前に持っていかれる。
					""");
			gm.waitEnter();
			
			gm.say("""
					--- 転倒！ ---
					--- 1D6 のダメージロール ---
					""");
			
			Dice damageDice = new Dice(1, 6);
			int damage = damageDice.roll();
			
			gm.sayf("--- %d のダメージを受ける ---", damage);
			player.damageHp(damage);
			gm.sayf("HP %d -> %d", player.getMaxHp(), player.getHp());
			
			if (player.isDead()) {
				return new DeathScene(ctx);
			}
			
			gm.waitEnter();
			
			gm.say("""
					「くそ……無事か！？」
					「無理をするな、次は確実に行け」
					""");
		}
		
		gm.say("""
				君は落ち着いて体勢を立て直す。
				山は、まだ始まったばかりだ。
				""");
		
		return new RuinsDiscoveryScene(ctx);
	}
}
