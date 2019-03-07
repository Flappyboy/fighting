package cn.edu.nju.software.game.fighting.model.command.HomeCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

public class NewGameCommand implements ICommand {
    @Override
    public String getName() {
        return "新的游戏";
    }

    @Override
    public void Execute() {
        GameManager.getInstance().startNewGame();
    }
}
