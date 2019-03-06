package cn.edu.nju.software.game.fighting.model.command.NewRoleCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

public class NewRoleCommand implements ICommand {

    Role role;
    Game game;

    public NewRoleCommand(Role role, Game game) {
        this.role = role;
        this.game = game;
    }

    @Override
    public String getCommandName() {
        return "创建角色";
    }

    @Override
    public void Execute() {
        game.createNewRole(role);
    }
}
