package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.attribute.State;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.HomeScenario;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

public class GameOverState extends StateAdapter {
    public GameOverState(Game game) {
        super(game);
    }

    @Override
    public void reStart() {
        GameManager.getInstance().changeScenario(HomeScenario.class);
    }
}
