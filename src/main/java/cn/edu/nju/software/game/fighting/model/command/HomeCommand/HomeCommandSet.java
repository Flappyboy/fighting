package cn.edu.nju.software.game.fighting.model.command.HomeCommand;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;

public class HomeCommandSet extends CommandSet {

    public HomeCommandSet() {
        super("主页");
    }

    public static HomeCommandSet getInstance() {
        HomeCommandSet homeCommandSet = new HomeCommandSet();

        homeCommandSet.addCommand(new NewGameCommand());
        homeCommandSet.addCommand(new ContinueGameCommand());
        homeCommandSet.addCommand(new GameInfoCommand());

        return homeCommandSet;
    }
}
