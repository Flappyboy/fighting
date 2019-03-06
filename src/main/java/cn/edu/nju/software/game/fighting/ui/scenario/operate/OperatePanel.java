package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.model.scenario.IScenario;

import javax.swing.*;

public abstract class OperatePanel extends JPanel {
    IScenario scenario;

    public IScenario getScenario() {
        return scenario;
    }
}
