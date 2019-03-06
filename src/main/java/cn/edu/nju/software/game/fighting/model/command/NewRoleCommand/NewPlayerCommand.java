package cn.edu.nju.software.game.fighting.model.command.NewRoleCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

public class NewPlayerCommand implements ICommand {

    Player player;
    Game game;

    public NewPlayerCommand(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    @Override
    public String getCommandName() {
        return "创建角色";
    }

    @Override
    public void Execute() {
        game.createNewPlayer(player);
    }
}
