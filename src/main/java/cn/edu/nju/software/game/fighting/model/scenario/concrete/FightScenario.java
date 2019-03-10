package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand.NewPlayerCommandSet;
import cn.edu.nju.software.game.fighting.model.command.UsualCommand.BagCommandSet;
import cn.edu.nju.software.game.fighting.model.command.fight.FightCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

public class FightScenario extends SharedScenario {

    public FightScenario() {
        super("战斗");
    }


    @Override
    protected void createCommandSets() {
        commandSetList.add(FightCommandSet.getInstance());
        commandSetList.add(BagCommandSet.getInstance());
    }
}
