package cn.edu.nju.software.game.fighting.model.role;

public enum State {
    DAZZLE("眩晕"), POISON("中毒");

    private String name;

    State(String name) {
        this.name = name;
    }
}
