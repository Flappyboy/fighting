package cn.edu.nju.software.game.fighting.model.command.HomeCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

public class GameInfoCommand implements ICommand {
    @Override
    public String getName() {
        return "相关信息";
    }

    @Override
    public void Execute() {
        GameManager.getInstance().showLog("本游戏为练习设计模式而创作！");
    }
}
