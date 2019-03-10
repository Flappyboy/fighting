package cn.edu.nju.software.game.fighting.model.command.HomeCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.BuildGameScenario;

import java.util.List;
import java.util.Map;

public class NewGameCommand extends GameCommand {
    public NewGameCommand() {
        super("新的游戏");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        GameManager.getInstance().getGameLogPanel().clear();
        GameManager.getInstance().changeScenario(BuildGameScenario.class);
    }
}
