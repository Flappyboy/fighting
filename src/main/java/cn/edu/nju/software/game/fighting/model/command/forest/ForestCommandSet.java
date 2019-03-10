package cn.edu.nju.software.game.fighting.model.command.forest;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.ContinueGameCommand;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.GameInfoCommand;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.NewGameCommand;
import cn.edu.nju.software.game.fighting.model.command.base.PlayerInfoCommand;
import cn.edu.nju.software.game.fighting.model.command.goCommand.GoToFightingCommand;
import cn.edu.nju.software.game.fighting.model.command.goCommand.GoToSmithyCommand;

public class ForestCommandSet extends CommandSet {

    public ForestCommandSet() {
        super("野外");
    }

    public static ForestCommandSet getInstance() {
        ForestCommandSet forestCommandSet = new ForestCommandSet();

        forestCommandSet.addCommand(new GoToFightingCommand());
        forestCommandSet.addCommand(new GoToSmithyCommand());
        forestCommandSet.addCommand(new PlayerInfoCommand());

        return forestCommandSet;
    }
}
