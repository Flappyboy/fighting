package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.character.ICharacter;
import cn.edu.nju.software.game.fighting.model.command.NewCharacterCommand.NewCharacterCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class NewCharacterScenario extends SharedScenario {

    ICharacter character;

    public NewCharacterScenario() {
        scenarioName = "新建角色";
    }

    @Override
    protected OperatePanel createOperatePanel() {
        return new BaseScenarioOperatePanel(this);
    }

    @Override
    protected void createCommandSets() {
        commandSetList.add(NewCharacterCommandSet.getInstance(character, getGame()));
    }
}
