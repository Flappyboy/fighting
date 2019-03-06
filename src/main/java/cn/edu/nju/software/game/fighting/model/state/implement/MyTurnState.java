package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

public class MyTurnState extends StateAdapter {
    public MyTurnState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        //根据已选的技能，身上的装备，还有属性来计算伤害值
        int hurt = 0;
        game.say("------使用了什么技能------");
        game.setState(new BeforeMyTurnState(game));
    }
}
