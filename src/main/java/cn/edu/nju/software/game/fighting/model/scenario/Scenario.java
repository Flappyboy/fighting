package cn.edu.nju.software.game.fighting.model.scenario;

import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

import java.util.ArrayList;
import java.util.List;

public abstract class Scenario extends GameElement{

    protected List<CommandSet> commandSetList = new ArrayList<>();

    protected OperatePanel operatePanel;

    public Scenario(String name) {
        super(name);
    }

    public OperatePanel getOperatePanel() {
        if(operatePanel==null){
            operatePanel = createOperatePanel();
        }
        return operatePanel;
    }

    protected abstract OperatePanel createOperatePanel();

    public List<CommandSet> getCommandSetList() {
        if(commandSetList.size()==0){
            createCommandSets();
        }
        return commandSetList;
    }

    protected abstract void createCommandSets();

    public void eventHandel(String event, String... params) {

    }
}
