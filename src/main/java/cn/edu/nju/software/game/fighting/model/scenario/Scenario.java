package cn.edu.nju.software.game.fighting.model.scenario;

import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.BaseScenarioOperatePanel;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

import java.util.ArrayList;
import java.util.List;

public abstract class Scenario extends GameElement{

    protected List<CommandSet> commandSetList = new ArrayList<>();

    protected OperatePanel operatePanel;

    boolean refresh = false;

    public Scenario(String name) {
        super(name);
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

    public OperatePanel getOperatePanel() {
        if(operatePanel != null && refresh){
            operatePanel = createOperatePanel(operatePanel.getTab());
        }else{
            operatePanel = createOperatePanel(0);
        }
        return operatePanel;
    }

    protected OperatePanel createOperatePanel(int tab) {
        return new BaseScenarioOperatePanel(this, tab);
    }

    public List<CommandSet> getCommandSetList() {
//        if(commandSetList.size()==0){
        commandSetList.clear();
            createCommandSets();
//        }
        return commandSetList;
    }

    protected abstract void createCommandSets();

    public void eventHandel(String event, String... params) {

    }

    @Override
    public String getDesc() {
        return "场景"+name;
    }
}
