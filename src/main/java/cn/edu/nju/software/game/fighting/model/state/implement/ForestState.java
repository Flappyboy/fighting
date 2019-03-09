package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

import java.util.Random;

public class ForestState extends StateAdapter {
    Random random = new Random();

    public ForestState(Game game) {
        super(game);
    }

    //随机遇怪，如果遇到，进入beforeMyTurn状态
    //否则，进入到SceneState。
    @Override
    public void randomEnemy() {
        int nextInt = random.nextInt(5);
        game.say("------去探险------");
        game.say("------正在寻找怪物------");
        //遇到怪物，准备战斗
        if (nextInt % 2 == 0) {
            try {
                //随机等待不超过5秒时间，模拟在林中转悠的过程
                Thread.sleep(nextInt * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.say("------前方出现哥布林！准备作战！------");
            game.setState(new BeforeMyTurnState(game));
        } else {
            //没有遇到怪物，固定时间后返回
            try {
                Thread.sleep(4 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.say("------未遇到怪物------");
        }
    }

    //访问铁匠铺
    @Override
    public void visitSmithy() {
        game.say("------您已进入铁匠铺------");
        game.setState(new SmithyState(game));
    }
}
