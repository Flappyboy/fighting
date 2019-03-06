package cn.edu.nju.software.game.fighting.ui;

import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

import javax.swing.*;
import java.awt.*;

public class GameOperatePanel extends JTabbedPane {

    JPanel gamePanel;

    public GameOperatePanel() {
        setBorder(BorderFactory.createEtchedBorder());

        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        addTab("游戏界面",gamePanel);

        SysPanel sysPanel= new SysPanel();
        addTab("系统界面",sysPanel);
    }

    public void changeGameOperatePanel(OperatePanel operatePanel)
    {
        gamePanel.removeAll();
        JLabel jLabel = new JLabel(operatePanel.getScenario().getScenarioName());
        gamePanel.add(jLabel, BorderLayout.NORTH);
        gamePanel.add(operatePanel, BorderLayout.CENTER);
        gamePanel.validate();
        gamePanel.repaint();
    }
}
