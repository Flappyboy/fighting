package cn.edu.nju.software.game.fighting.model.role;

public enum Profession {

    WARRIOR("战士"), MAGE("法师");

    private String name;

    Profession(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
