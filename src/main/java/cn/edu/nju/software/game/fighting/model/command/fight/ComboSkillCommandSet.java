package cn.edu.nju.software.game.fighting.model.command.fight;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.base.EnemyInfoCommand;
import cn.edu.nju.software.game.fighting.model.command.base.PlayerInfoCommand;
import cn.edu.nju.software.game.fighting.model.command.demo.RadioTableCommand;

public class FightCommandSet extends CommandSet {

    public FightCommandSet() {
        super("技能");
    }

    public static FightCommandSet getInstance() {
        FightCommandSet demoCommandSet = new FightCommandSet();

        demoCommandSet.addCommand(new SkillCommand());
        demoCommandSet.addCommand(new EnemyInfoCommand());
        demoCommandSet.addCommand(new PlayerInfoCommand());

        return demoCommandSet;
    }
}
