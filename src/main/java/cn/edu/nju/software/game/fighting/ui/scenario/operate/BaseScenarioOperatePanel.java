package cn.edu.nju.software.game.fighting.ui.scenario.operate;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.ICommand;
import cn.edu.nju.software.game.fighting.model.scenario.Scenario;
import cn.edu.nju.software.game.fighting.ui.base.BaseBtn;
import cn.edu.nju.software.game.fighting.ui.base.OperateElementPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BaseScenarioOperatePanel extends OperatePanel {

    JTabbedPane jTabbedPane;

    public BaseScenarioOperatePanel(Scenario scenario) {
        super(scenario);
        init(scenario.getCommandSetList());
    }

    public BaseScenarioOperatePanel(CommandSet commandSet, Scenario scenario) {
        super(scenario);
        init(commandSet);
    }

    public void init(List<CommandSet> commandSetList) {
        if(commandSetList.size()==1){
            Box box = new Box(BoxLayout.Y_AXIS);
            add(box);
            init(commandSetList.get(0));

        }else if(commandSetList.size()>1)
        {
            jTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
            for (CommandSet commandSet :
                    commandSetList) {
                jTabbedPane.add(processTitle(commandSet.getName()), new BaseScenarioOperatePanel(commandSet, scenario));
            }
            add(jTabbedPane);
        }
    }

    private String processTitle(String name){
        String result = "<html>";
        String br = "<br>";
        for(int i=0; i<name.length(); i++){
            result+=name.charAt(i);
            if(i!=name.length()-1){
                result+=br;
            }
        }
        return result+"</html>";
    }
    public void init(CommandSet commandSet) {
            Box box = new Box(BoxLayout.Y_AXIS);
            add(box);

            Iterator<ICommand> commandIterator = commandSet.getCommandIterator();

            while(commandIterator.hasNext()){
                ICommand command = commandIterator.next();

                Map<Object, OperateElementPanel> operateElementPanelMap = command.getOperateElementPanelMap();
                for (Object key : operateElementPanelMap.keySet()) {
                    box.add(Box.createVerticalStrut(10));
                    box.add(operateElementPanelMap.get(key));
                }

                box.add(Box.createVerticalStrut(20));
                BaseBtn saveBtn = new BaseBtn(command.getName());
                saveBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Map<Object, Object> map = new HashMap();
                        for (Object key : operateElementPanelMap.keySet()) {
                            map.put(key, operateElementPanelMap.get(key).getData());
                        }
                        command.Execute(map);
                    }
                });
                box.add(saveBtn);
            }
    }
}
