package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand.NewPlayerCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class NewPlayerScenario extends SharedScenario {

    public NewPlayerScenario() {
        super("新建角色");
    }


    @Override
    protected void createCommandSets() {
        commandSetList.add(NewPlayerCommandSet.getInstance());
    }
}
