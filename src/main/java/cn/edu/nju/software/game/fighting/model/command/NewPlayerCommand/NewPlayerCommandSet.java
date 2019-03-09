package cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;

public class NewPlayerCommandSet extends CommandSet {

    private NewPlayerCommandSet() {
        super("新建角色");
    }

    public static NewPlayerCommandSet getInstance() {
        NewPlayerCommandSet newPlayerCommandSet = new NewPlayerCommandSet();

        newPlayerCommandSet.addCommand(new NewPlayerCommand(GameManager.getInstance().getGameBuilder()));

        return newPlayerCommandSet;
    }
}
