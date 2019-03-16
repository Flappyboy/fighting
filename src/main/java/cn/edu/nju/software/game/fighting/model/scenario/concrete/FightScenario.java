package cn.edu.nju.software.game.fighting.model.scenario.concrete;

import cn.edu.nju.software.game.fighting.model.command.UsualCommand.BagCommandSet;
import cn.edu.nju.software.game.fighting.model.command.fight.ComboSkillCommandSet;
import cn.edu.nju.software.game.fighting.model.command.fight.FightCommandSet;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
public class FightScenario extends SharedScenario {

    public FightScenario() {
        super("战斗");
    }

    @Override
    protected void createCommandSets() {
        commandSetList.add(FightCommandSet.getInstance());
        commandSetList.add(ComboSkillCommandSet.getInstance());
        commandSetList.add(BagCommandSet.getInstance());
    }
}
