package cn.edu.nju.software.game.fighting.ui.base;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends OperateElementPanel{

    JTextField jTextField;
    public TextPanel(String title, String defaultValue) {
        JLabel jLabel = new JLabel(title);
        add(jLabel);
        jTextField = new JTextField(defaultValue);
        jTextField.setColumns(10);
        jTextField.setFont(new Font("楷体",Font.BOLD,16));
        jTextField.setBackground(Color.WHITE);
        add(jTextField);
    }

    @Override
    public Object getData() {
        return jTextField.getText().trim();
    }
}
