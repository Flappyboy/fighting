package cn.edu.nju.software.game.fighting.model.command;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.ui.base.OperateElementPanel;

import java.util.*;

public abstract class GameCommand extends GameElement implements ICommand {

    private final Map<Object, OperateElementPanel> operateElementPanelMap = new LinkedHashMap();

    public GameCommand(String name) {
        super(name);
    }

    @Override
    public Map<Object, OperateElementPanel> getOperateElementPanelMap() {
        return operateElementPanelMap;
    }

    protected void put(Object name, OperateElementPanel operateElementPanel){
        operateElementPanelMap.put(name, operateElementPanel);
    }

    @Override
    public String getDesc() {
        return "操作："+name;
    }
}
