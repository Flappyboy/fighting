package cn.edu.nju.software.game.fighting.model.command.BuildGameCommand;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;

public class BuildGameCommandSet extends CommandSet {

    public BuildGameCommandSet() {
        super("创建游戏");
    }

    public static BuildGameCommandSet getInstance() {
        BuildGameCommandSet set = new BuildGameCommandSet();
        set.addCommand(new SelectModeCommand());
        return set;
    }
}
