package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;

public interface IGameBuilder {

    void buildPlayerGameElementFactory();

    void buildEnemyGameElementFactory();

    void buildPlayer(String name, Gender gender, Profession profession);

    void buildState();

    void buildInitItem();

    void buildInitSkill();

    Game result();
}
