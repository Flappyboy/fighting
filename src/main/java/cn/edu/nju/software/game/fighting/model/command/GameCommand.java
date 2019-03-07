package cn.edu.nju.software.game.fighting.model.command;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.GameElement;

public abstract class GameCommand extends GameElement implements ICommand {

    public GameCommand(String name) {
        super(name);
    }
}
