package cn.edu.nju.software.game.fighting.model.role.attribute;

public enum Profession {

    WARRIOR("战士"), MAGE("法师"), SWORDMAN("剑士"), NONE("无");

    private String name;

    Profession(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
