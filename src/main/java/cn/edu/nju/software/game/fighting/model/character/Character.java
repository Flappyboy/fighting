package cn.edu.nju.software.game.fighting.model.character;

//Bridge pattern

public abstract class Character {
    Gender gender;
    BodyType bodyType;

    String id;
    String name;
    Integer level;
}
