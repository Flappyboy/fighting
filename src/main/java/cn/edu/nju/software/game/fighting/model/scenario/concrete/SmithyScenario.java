package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.command.NewRoleCommand.NewPlayerCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.NewPlayerScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class SmithyScenario extends SharedScenario {

    public SmithyScenario() {
        super("铁匠铺");
    }

    @Override
    protected OperatePanel createOperatePanel() {
        return new NewPlayerScenarioOperatePanel(this);
    }

    @Override
    protected void createCommandSets() {
        commandSetList.add(NewPlayerCommandSet.getInstance());
    }
}
