package cn.edu.nju.software.game.fighting.model.role.attribute;

public enum Race {

    HUMAN("人族"), MONSTER("魔物");

    private String name;

    Race(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
