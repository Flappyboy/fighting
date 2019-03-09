package cn.edu.nju.software.game.fighting.model.command;

import cn.edu.nju.software.game.fighting.ui.base.OperateElementPanel;

import java.util.List;
import java.util.Map;

public interface ICommand {

    String getName();

    Map<Object, OperateElementPanel> getOperateElementPanelMap();

    void Execute(Map<Object, Object> objects);
}
