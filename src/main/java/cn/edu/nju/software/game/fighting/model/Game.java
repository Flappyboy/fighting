package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.character.ICharacter;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.NewCharacterScenario;

public class Game {

    public void start()
    {
        GameManager.getInstance().changeScenario(NewCharacterScenario.class);
    }

    public void createNewCharacter(ICharacter character) {}

    public void save(){}
}
