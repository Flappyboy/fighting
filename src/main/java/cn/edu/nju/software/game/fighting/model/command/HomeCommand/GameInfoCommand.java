package cn.edu.nju.software.game.fighting.model.command.HomeCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

import java.util.List;
import java.util.Map;

public class GameInfoCommand extends GameCommand {
    public GameInfoCommand() {
        super("相关信息");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        GameManager.getInstance().showLog("本游戏为练习设计模式而创作！");
    }
}
