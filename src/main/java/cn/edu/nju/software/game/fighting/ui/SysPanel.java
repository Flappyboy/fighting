package cn.edu.nju.software.game.fighting.ui;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.ui.base.BaseBtn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SysPanel extends JPanel {

    public SysPanel() {
        Box box = new Box(BoxLayout.Y_AXIS);
        add(box);

        box.add(Box.createVerticalStrut(20));
        BaseBtn saveBtn = new BaseBtn("  保存游戏  ");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().save();
            }
        });
        box.add(saveBtn);

        box.add(Box.createVerticalStrut(20));
        BaseBtn backBtn = new BaseBtn("返回主菜单");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().returnHomeScenario();
            }
        });
        box.add(backBtn);

        box.add(Box.createVerticalStrut(20));
        BaseBtn exitBtn = new BaseBtn("  退出游戏  ");
        exitBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GameManager.getInstance().exit();
                    }
                });
        box.add(exitBtn);

    }
}
