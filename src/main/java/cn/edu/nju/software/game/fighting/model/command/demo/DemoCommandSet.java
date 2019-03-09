package cn.edu.nju.software.game.fighting.model.command.demo;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.ContinueGameCommand;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.GameInfoCommand;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.NewGameCommand;
import cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand.NewPlayerCommand;

public class DemoCommandSet extends CommandSet {

    public DemoCommandSet() {
        super("Demo");
    }

    public static DemoCommandSet getInstance() {
        DemoCommandSet demoCommandSet = new DemoCommandSet();

        demoCommandSet.addCommand(new RadioTableCommand());

        return demoCommandSet;
    }
}
