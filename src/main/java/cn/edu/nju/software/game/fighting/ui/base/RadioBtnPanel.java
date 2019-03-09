package cn.edu.nju.software.game.fighting.ui.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class RadioBtnPanel<T> extends OperateElementPanel{

    ButtonGroup buttonGroup;
    T selected = null;
    Map<String, T> objectss;
    public RadioBtnPanel(Map<String, T> objects) {
        this.objectss = objects;
        Box box = new Box(BoxLayout.Y_AXIS);
        add(box);
        buttonGroup = new ButtonGroup();

        for (String key : objects.keySet()) {
            JRadioButton btn=new JRadioButton(key);
            btn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selected = objectss.get(btn.getText());
                }
            });
            buttonGroup.add(btn);
            box.add(btn);
        }
    }

    @Override
    public T getData() {
        return selected;
    }
}
