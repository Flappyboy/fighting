package cn.edu.nju.software.game.fighting.model.scenario;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.ui.scenario.operate.OperatePanel;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseScenario implements IScenario{

    protected List<CommandSet> commandSetList = new ArrayList<>();

    protected OperatePanel operatePanel;

    protected String scenarioName;

    @Override
    public OperatePanel getOperatePanel() {
        if(operatePanel==null){
            operatePanel = createOperatePanel();
        }
        return operatePanel;
    }

    public Game getGame(){
        return GameManager.getInstance().getGameInstance();
    }

    protected abstract OperatePanel createOperatePanel();

    @Override
    public String getScenarioName() {
        return scenarioName;
    }

    @Override
    public List<CommandSet> getCommandSetList() {
        if(commandSetList.size()==0){
            createCommandSets();
        }
        return commandSetList;
    }

    protected abstract void createCommandSets();

    @Override
    public void eventHandel(String event, String... params) {

    }
}
