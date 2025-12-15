package scene;

import game.GameContext;

public class IntroScene extends BaseScene implements Scene {
    public IntroScene(GameContext ctx) {
        super(ctx);
    }
    
    @Override
    public Scene play() {
    	gm.say("南極大陸。\n人類が地図に書き残した、最後の空白。");
    	gm.waitEnter();
    	
    	gm.say("この地で行われているのは、\n単なる冒険ではない。\n地質と生命の歴史を解き明かすための、\n国際的な学術調査だ。");
    	gm.waitEnter();
    	
    	gm.say("調査隊はすでに南極に入り、\n拠点となるキャンプの設営を終えている。\n最新の装備と航空機を用いた、\n順調な探検計画――少なくとも、当初はそうだった。");
    	gm.waitEnter();
    	
    	gm.say("だが、調査の過程で発見されたものが、\nすべてを変えた。");
    	gm.waitEnter();
    	
    	gm.say("地球の進化史に当てはまらない化石。\n常識では説明のつかない生命の痕跡。\nそして、地図に存在しない巨大な山脈。");
    	gm.waitEnter();
    	
    	gm.say("あまりにも古く、\nあまりにも異様なその山脈は、\nまるでこの大地そのものが、\n何かを拒んでいるかのようだった。");
    	gm.waitEnter();
    	
    	gm.say("それでも調査は続行された。\n科学的好奇心と使命感が、\n引き返すという選択を遠ざけたのだ。");
    	gm.waitEnter();
    	
    	gm.say("そんな中で、隊員の一人が体調を崩し、\n調査隊は欠員を出すことになる。");
    	gm.waitEnter();
    	
    	gm.say("――そして、君に声がかかった。");
    	gm.waitEnter();
    	
    	gm.say("経験、技能、そして運。\n条件を満たす人員は多くなかった。");
    	gm.waitEnter();
    	
    	gm.say("君は調査隊に合流する最後のメンバーとして、\n南極へ向かうことになった。");
    	gm.waitEnter();
    	
    	gm.say("キャンプではすでに、\n先行した隊員たちが君を待っている。\n彼らはまだ知らない。\nこの探検が、どこへ辿り着くのかを。");
    	gm.waitEnter();
    	
    	gm.say("あるいは――\n知ってはならないことを、\nすでに踏み越えてしまっているのかもしれない。");
    	gm.say("");
    	gm.say("--- Enterでキャンプへ合流する ---");
    	gm.waitEnter();
    	
        return new CharacterCreateScene(ctx);
    }
}
