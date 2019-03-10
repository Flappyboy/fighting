package cn.edu.nju.software.game.fighting.model.command.goCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.SmithyScenario;

import java.util.Map;

public class GoToSmithyCommand extends GameCommand {
    public GoToSmithyCommand() {
        super("去铁匠铺");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        getGame().visitSmithy();
    }
}
