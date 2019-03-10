package cn.edu.nju.software.game.fighting.model.command.base;

import cn.edu.nju.software.game.fighting.model.IGameBuilder;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.ui.base.RadioBtnPanel;
import cn.edu.nju.software.game.fighting.ui.base.TextPanel;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerInfoCommand extends GameCommand {
    public PlayerInfoCommand() {
        super("角色信息");
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        String info = getGame().getPlayer().getDesc();
        say(info);
    }
}
