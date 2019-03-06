package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;

import javax.swing.*;

public abstract class OperatePanel extends JPanel {
    SharedScenario scenario;

    public SharedScenario getScenario() {
        return scenario;
    }
}
