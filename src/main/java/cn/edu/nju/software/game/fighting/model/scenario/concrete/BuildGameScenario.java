package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.command.BuildGameCommand.BuildGameCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class BuildGameScenario extends SharedScenario {

    public BuildGameScenario() {
        super("选择游戏难度");
    }

    @Override
    protected OperatePanel createOperatePanel() {
        return new BaseScenarioOperatePanel(this);
    }

    @Override
    protected void createCommandSets() {
        commandSetList.add(BuildGameCommandSet.getInstance());
    }
}
