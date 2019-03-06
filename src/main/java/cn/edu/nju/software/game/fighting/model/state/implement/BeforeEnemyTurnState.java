package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

public class BeforeEnemyTurnState extends StateAdapter {
    public BeforeEnemyTurnState(Game game) {
        super(game);
    }

    @Override
    public void prepareBeforeEnemyTurn() {
        //此处需要计算受到的攻击伤害
        int hurt = 0;
        //根据伤害判断角色是否死亡
        boolean dead = false;
        if (dead) {
            game.say("------怪物已死亡，获得多少经验，多少金币-------");
            game.setState(new BattleOverState(game));
        } else {
            game.say("------怪物受到多少点伤害------");
            game.setState(new EnemyTurnState(game));
        }
    }
}
