package cn.edu.nju.software.game.fighting.model.command.goCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.ForestScenario;

import java.util.Map;

public class GoToForestCommand extends GameCommand {
    public GoToForestCommand() {
        super("去野外");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        GameManager.getInstance().changeScenario(ForestScenario.class);
    }
}
