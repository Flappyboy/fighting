package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.model.character.Character;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.ICommand;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.NewCharacterScenario;
import cn.edu.nju.software.game.fighting.ui.base.BaseBtn;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NewCharacterScenarioOperatePanel extends OperatePanel {

    public NewCharacterScenarioOperatePanel(NewCharacterScenario scenario) {
        this.scenario = scenario;
        List<CommandSet> commandSetList =  scenario.getCommandSetList();
        ICommand command = commandSetList.get(0).getCommandIterator().next();

        Box box = new Box(BoxLayout.Y_AXIS);
        add(box);

        box.add(Box.createVerticalStrut(20));
        JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("楷体",Font.BOLD,16));
        jTextField.setBackground(Color.WHITE);
        jTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        box.add(jTextField);

        box.add(Box.createVerticalStrut(20));
        BaseBtn saveBtn = new BaseBtn(command.getCommandName());
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Character character = scenario.getCharacter();
                command.Execute();
            }
        });
        box.add(saveBtn);
    }
}
