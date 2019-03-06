package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.NewPlayerScenario;
import cn.edu.nju.software.game.fighting.model.state.State;
import cn.edu.nju.software.game.fighting.model.state.implement.BeginState;

public class Game {
    private State state = new BeginState(this);

    private Player player;

    public void start() {
        GameManager.getInstance().changeScenario(NewPlayerScenario.class);
    }

    public void createNewPlayer(Role role) {
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
        this.state = state;
    }
}
