package cn.edu.nju.software.game.fighting.model.command.base;

import cn.edu.nju.software.game.fighting.model.command.GameCommand;

import java.util.Map;

public class EnemyInfoCommand extends GameCommand {
    public EnemyInfoCommand() {
        super("敌方信息");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        String info = getGame().getEnemy().getDesc();
        say(info);
    }
}
