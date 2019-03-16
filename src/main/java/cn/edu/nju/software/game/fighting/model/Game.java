package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.factory.quality.QualityFactory;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.scenario.Scenario;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.*;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.model.state.State;
import cn.edu.nju.software.game.fighting.model.state.implement.*;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

import java.util.HashMap;

public class Game extends GameElement{
    private State state;

    private State initState;

    private Role player;

    private Role enemy;

    private transient Scenario scenario;

    private QualityFactory playerGameElementFactory;
    private QualityFactory enemyGameElementFactory;

    public final static HashMap<Class<? extends State>, Class<? extends Scenario>> StateScenarioMap =
            new HashMap<Class<? extends State>, Class<? extends Scenario>>(){
                {
                    put(BeginState.class, NewPlayerScenario.class);
                    put(SmithyState.class, SmithyScenario.class);
                    put(ForestState.class, ForestScenario.class);
                    put(MyTurnState.class, FightScenario.class);
                    put(EnemyTurnState.class, FightScenario.class);
                    put(GameOverState.class, HomeScenario.class);
                }
    };

    public Game clone(){
        return CloneUtils.clone( this);
    }

    public void start(){
        say("-----------游戏开始----------");
        if(state != null){
            setState(state);
        }else {
            setState(initState);
        }
    }

    @Override
    public String getDesc() {
        return "游戏："+name;
    }

    public Game(String name) {
        super(name);
    }

    public void save() {
    }

    public void say(String words) {
        GameManager.getInstance().showLog(words);
    }
    public void sayLine() {
        say("-------------------------------------");
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        Class<? extends Scenario> scenarioClass = StateScenarioMap.get(state.getClass());
        if (scenario==null || (scenarioClass != null)){
            if(scenario!=null && scenario.getClass().equals(scenarioClass)){
                refresh();
            }else {
                this.scenario = GameManager.getInstance().changeScenario(scenarioClass);
            }
        }
        this.state = state;
    }

    public Role getPlayer() {
        return player;
    }

    public void setPlayer(Role player) {
        this.player = player;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public QualityFactory getPlayerGameElementFactory() {
        return playerGameElementFactory;
    }

    public void setPlayerGameElementFactory(QualityFactory playerGameElementFactory) {
        this.playerGameElementFactory = playerGameElementFactory;
    }

    public QualityFactory getEnemyGameElementFactory() {
        return enemyGameElementFactory;
    }

    public void setEnemyGameElementFactory(QualityFactory enemyGameElementFactory) {
        this.enemyGameElementFactory = enemyGameElementFactory;
    }

    public Role getEnemy() {
        return enemy;
    }

    public void setEnemy(Role enemy) {
        this.enemy = enemy;
    }

    public State getInitState() {
        return initState;
    }

    public void setInitState(State initState) {
        this.initState = initState;
    }


    public void visitSmithy(){
        state.visitSmithy();
    }

    public void randomEnemy(){
        state.randomEnemy();
    }

    public void visitForest(){
        state.visitForest();
    }

    public void attack(Skill skill){
        state.action(skill);
    }

    public void useItem(Item item){state.useItem(item);}

    public void refresh() {
        GameManager.getInstance().changeScenario(this.scenario.getClass(),true);
    }
}
