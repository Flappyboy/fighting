package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.model.scenario.Scenario;

import javax.swing.*;

public abstract class OperatePanel extends JPanel {
    Scenario scenario;

    public OperatePanel(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }

    abstract public int getTab();
}
