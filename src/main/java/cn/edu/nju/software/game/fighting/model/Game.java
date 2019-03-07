package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.scenario.Scenario;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.*;
import cn.edu.nju.software.game.fighting.model.state.State;
import cn.edu.nju.software.game.fighting.model.state.implement.*;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

import java.util.HashMap;

public class Game extends GameElement{
    private State state;

    private Player player;

    private transient Scenario scenario;

    public static HashMap<Class<? extends State>, Class<? extends Scenario>> StateScenarioMap =
            new HashMap<Class<? extends State>, Class<? extends Scenario>>(){
                {
                    put(BeginState.class, NewPlayerScenario.class);
                    put(SmithyState.class, SmithyScenario.class);
                    put(SceneState.class, ForestScenario.class);
                    put(MyTurnState.class, FightScenario.class);
                }
    };

    public Game clone(){
        return CloneUtils.clone( this);
    }

    public void reload(){

    }

    public Game(String name) {
        super(name);
    }

    public void newStart() {
        state = new BeginState(this);
    }

    public void save() {
    }

    public void say(String words) {
        GameManager.getInstance().showLog(words);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        Class<? extends Scenario> scenarioClass = StateScenarioMap.get(state.getClass());
        if (scenarioClass != null && !scenarioClass.equals(scenario.getClass())){
            GameManager.getInstance().changeScenario(scenarioClass);
        }
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
