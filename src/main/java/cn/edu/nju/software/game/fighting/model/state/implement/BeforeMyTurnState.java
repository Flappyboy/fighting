package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

public class BeforeMyTurnState extends StateAdapter {
    public BeforeMyTurnState(Game game) {
        super(game);
    }

    //向myturn状态转变，做些准备动作
    @Override
    public void prepareBeforeMyTurn() {
        //此处需要计算受到的攻击伤害
        int hurt = 0;
        //根据伤害判断角色是否死亡
        boolean dead = false;
        if (dead) {
            game.say("------你已死亡,请重新创建角色-------");
            game.setState(new BattleOverState(game));
        } else {
            game.say("------受到多少点伤害------");
            game.setState(new MyTurnState(game));
        }
    }
}
