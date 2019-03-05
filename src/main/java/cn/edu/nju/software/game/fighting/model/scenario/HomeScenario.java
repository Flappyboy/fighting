package cn.edu.nju.software.game.fighting.model.scenario;

import cn.edu.nju.software.game.fighting.ui.scenario.operate.HomeScenarioOperatePanel;

import javax.swing.*;

public class HomeScenario implements Scenario{

    @Override
    public JComponent getOperatorPanel() {

        return new HomeScenarioOperatePanel();
    }
}
