package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand.NewPlayerCommandSet;
import cn.edu.nju.software.game.fighting.model.command.UsualCommand.BagCommandSet;
import cn.edu.nju.software.game.fighting.model.command.forest.ForestCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class ForestScenario extends SharedScenario {

    public ForestScenario() {
        super("野外");
    }

    @Override
    protected OperatePanel createOperatePanel() {
        return new BaseScenarioOperatePanel(this);
    }

    @Override
    protected void createCommandSets() {
        commandSetList.add(ForestCommandSet.getInstance());
        commandSetList.add(BagCommandSet.getInstance());
    }
}
