package cn.edu.nju.software.game.fighting.model.item;

import cn.edu.nju.software.game.fighting.model.GameElement;

public abstract class Item extends GameElement {
    private String name;

    public Item(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
