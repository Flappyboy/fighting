package cn.edu.nju.software.game.fighting.model.command.HomeCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

import java.util.List;
import java.util.Map;

public class ContinueGameCommand extends GameCommand {
    public ContinueGameCommand() {
        super("继续游戏");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        GameManager.getInstance().continueGame();
    }


//    @Override
//    public void Execute(Object ) {
//        GameManager.getInstance().startNewGame();
//    }


}
