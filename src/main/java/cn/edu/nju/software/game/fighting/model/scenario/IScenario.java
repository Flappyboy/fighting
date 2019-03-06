package cn.edu.nju.software.game.fighting.model.scenario;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

import java.util.List;

public interface IScenario {

    List<CommandSet> getCommandSetList();

    OperatePanel getOperatePanel();

    String getScenarioName();
}
