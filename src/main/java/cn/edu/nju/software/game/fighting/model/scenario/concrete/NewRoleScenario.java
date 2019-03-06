package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.command.NewRoleCommand.NewRoleCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class NewRoleScenario extends SharedScenario {

    Role role;

    public NewRoleScenario() {
        scenarioName = "新建角色";
    }

    @Override
    protected OperatePanel createOperatePanel() {
        return new BaseScenarioOperatePanel(this);
    }

    @Override
    protected void createCommandSets() {
        commandSetList.add(NewRoleCommandSet.getInstance(role, getGame()));
    }

    public Role getRole() {
        return role;
    }
}
