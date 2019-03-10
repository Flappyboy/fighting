package cn.edu.nju.software.game.fighting.model.item;

import cn.edu.nju.software.game.fighting.model.GameElement;

public abstract class Item extends GameElement {
    public Item(String name) {
        super(name);
    }

    public abstract void use(GameElement target);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Item clone();
}
