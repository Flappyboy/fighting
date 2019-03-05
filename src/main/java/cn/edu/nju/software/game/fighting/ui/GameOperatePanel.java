package cn.edu.nju.software.game.fighting.ui;

import javax.swing.*;
import java.awt.*;

public class GameOperatePanel extends JTabbedPane {

    JPanel gamePanel;

    public GameOperatePanel() {
        setBorder(BorderFactory.createEtchedBorder());

        gamePanel = gamePanel= new JPanel();
        addTab("游戏界面",gamePanel);

        SysPanel sysPanel= new SysPanel();
        addTab("系统界面",sysPanel);
    }

    public void changeGameOperatePanel(JComponent jComponent)
    {
        gamePanel.removeAll();
        gamePanel.add(jComponent);
    }
}
