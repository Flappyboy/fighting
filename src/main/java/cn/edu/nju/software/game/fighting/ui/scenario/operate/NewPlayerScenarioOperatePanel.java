package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.ICommand;
import cn.edu.nju.software.game.fighting.model.role.attribute.BodyType;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.role.attribute.Race;
import cn.edu.nju.software.game.fighting.model.scenario.Scenario;
import cn.edu.nju.software.game.fighting.ui.base.BaseBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NewPlayerScenarioOperatePanel extends OperatePanel {

    public NewPlayerScenarioOperatePanel(Scenario scenario) {
        this.scenario = scenario;
        List<CommandSet> commandSetList =  scenario.getCommandSetList();
        ICommand command = commandSetList.get(0).getCommandIterator().next();

        Box box = new Box(BoxLayout.Y_AXIS);
        add(box);

        box.add(Box.createVerticalStrut(20));
        JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("楷体",Font.BOLD,16));
        jTextField.setBackground(Color.WHITE);
        box.add(jTextField);

        box.add(Box.createVerticalStrut(20));
        BaseBtn saveBtn = new BaseBtn(command.getName());
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player player = scenario.getGame().getPlayer();
                player.setName(jTextField.getText().trim());
                player.setGender(Gender.MALE);
                player.setProfession(Profession.WARRIOR);
                player.setRace(Race.HUMAN);
                player.setBodyType(BodyType.MEDIUM);
                command.Execute();
            }
        });
        box.add(saveBtn);
    }
}
