package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.ICommand;
import cn.edu.nju.software.game.fighting.model.scenario.IScenario;
import cn.edu.nju.software.game.fighting.model.scenario.SharedScenario;
import cn.edu.nju.software.game.fighting.ui.base.BaseBtn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class BaseScenarioOperatePanel extends OperatePanel {

    public BaseScenarioOperatePanel(IScenario scenario) {
        this.scenario = scenario;
        List<CommandSet> commandSetList =  scenario.getCommandSetList();

        if(commandSetList.size()==1){
            Box box = new Box(BoxLayout.Y_AXIS);
            add(box);

            Iterator<ICommand> commandIterator = commandSetList.get(0).getCommandIterator();

            while(commandIterator.hasNext()){
                ICommand command = commandIterator.next();

                box.add(Box.createVerticalStrut(20));
                BaseBtn saveBtn = new BaseBtn(command.getCommandName());
                saveBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        command.Execute();
                    }
                });
                box.add(saveBtn);
            }

        }else if(commandSetList.size()>1)
        {

        }
    }
}
