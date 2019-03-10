package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand.NewPlayerCommandSet;
import cn.edu.nju.software.game.fighting.model.command.UsualCommand.BagCommandSet;
import cn.edu.nju.software.game.fighting.model.command.smithy.SmithyCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class SmithyScenario extends SharedScenario {

    public SmithyScenario() {
        super("铁匠铺");
    }


    @Override
    protected void createCommandSets() {
        commandSetList.add(SmithyCommandSet.getInstance());
        commandSetList.add(BagCommandSet.getInstance());
    }
}
