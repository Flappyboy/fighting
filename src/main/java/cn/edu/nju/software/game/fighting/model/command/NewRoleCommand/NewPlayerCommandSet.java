package cn.edu.nju.software.game.fighting.model.command.NewRoleCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;

public class NewPlayerCommandSet extends CommandSet {

    public static NewPlayerCommandSet getInstance() {
        NewPlayerCommandSet newPlayerCommandSet = new NewPlayerCommandSet();

        newPlayerCommandSet.addCommand(new NewPlayerCommand());

        return newPlayerCommandSet;
    }
}
