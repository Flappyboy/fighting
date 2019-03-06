package cn.edu.nju.software.game.fighting.model.command.NewRoleCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;

public class NewRoleCommandSet extends CommandSet {

    public static NewRoleCommandSet getInstance(Role role, Game game) {
        NewRoleCommandSet newRoleCommandSet = new NewRoleCommandSet();

        newRoleCommandSet.addCommand(new NewRoleCommand(role, game));

        return newRoleCommandSet;
    }
}
