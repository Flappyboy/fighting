package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.attribute.State;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

public class EnemyTurnState extends StateAdapter {
    public EnemyTurnState(Game game) {
        super(game);
    }

    @Override
    public void action(Skill skill) {
        skill.performs(game, game.getEnemy(), game.getPlayer());
        if(game.getPlayer().getState().equals(State.DEAD)){
            game.say("游戏结束");
            game.sayLine();
            game.setState(new GameOverState(game));
            return;
        }
        game.sayLine();
        game.say("进入玩家回合");
        game.setState(new MyTurnState(game));
    }
}
