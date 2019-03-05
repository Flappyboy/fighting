package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.ui.base.BaseBtn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScenarioOperatePanel extends OperatePanel {

    public HomeScenarioOperatePanel() {
        Box box = new Box(BoxLayout.Y_AXIS);
        add(box);

        box.add(Box.createVerticalStrut(20));
        BaseBtn saveBtn = new BaseBtn("  新的游戏  ");
        box.add(saveBtn);

        box.add(Box.createVerticalStrut(20));
        BaseBtn backBtn = new BaseBtn("  继续游戏  ");
        box.add(backBtn);

        box.add(Box.createVerticalStrut(20));
        BaseBtn exitBtn = new BaseBtn("  相关信息  ");
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().showLog("本游戏为练习设计模式而创作！");
            }
        });
        box.add(exitBtn);

    }
}
