package cn.edu.nju.software.game.fighting.model.command.HomeCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.ICommand;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.NewCharacterScenario;

public class ContinueGameCommand implements ICommand {
    @Override
    public String getCommandName() {
        return "继续游戏";
    }

    @Override
    public void Execute() {
        GameManager.getInstance().startNewGame();
    }
}
