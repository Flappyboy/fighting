package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.character.Character;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.NewCharacterScenario;
import cn.edu.nju.software.game.fighting.model.state.State;
import cn.edu.nju.software.game.fighting.model.state.implement.BattleOverState;
import cn.edu.nju.software.game.fighting.model.state.implement.BeginState;

public class Game {
    private State state = new BeginState(this);

    public void start() {
        GameManager.getInstance().changeScenario(NewCharacterScenario.class);
    }

    public void createNewCharacter(Character character) {
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
