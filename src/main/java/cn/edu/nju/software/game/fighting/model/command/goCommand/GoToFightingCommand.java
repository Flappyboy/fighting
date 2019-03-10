package cn.edu.nju.software.game.fighting.model.command.goCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.FightScenario;

import java.util.Map;

public class GoToFightingCommand extends GameCommand {
    public GoToFightingCommand() {
        super("打怪");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        getGame().randomEnemy();
    }
}
