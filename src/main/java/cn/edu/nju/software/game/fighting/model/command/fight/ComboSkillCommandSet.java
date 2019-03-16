package cn.edu.nju.software.game.fighting.model.command.fight;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.base.EnemyInfoCommand;
import cn.edu.nju.software.game.fighting.model.command.base.PlayerInfoCommand;

public class ComboSkillCommandSet extends CommandSet {

    public ComboSkillCommandSet() {
        super("组合技");
    }

    public static ComboSkillCommandSet getInstance() {
        ComboSkillCommandSet demoCommandSet = new ComboSkillCommandSet();

        demoCommandSet.addCommand(new ComboSkillCommand());
        demoCommandSet.addCommand(new EnemyInfoCommand());
        demoCommandSet.addCommand(new PlayerInfoCommand());

        return demoCommandSet;
    }
}
