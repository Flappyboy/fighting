package cn.edu.nju.software.game.fighting.model.state;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

import java.io.Serializable;

public class StateAdapter implements State, Serializable {
    protected Game game;

    public StateAdapter(Game game) {
        this.game = game;
    }

    @Override
    public void createRole() {
        System.out.println("您当前状态无法执行该操作");
    }

    @Override
    public void visitSmithy() {
        System.out.println("您当前状态无法执行该操作");
    }

    @Override
    public void visitForest() {
        System.out.println("您当前状态无法执行该操作");
    }

    @Override
    public void randomEnemy() {
        System.out.println("您当前状态无法执行该操作");
    }

    @Override
    public void action(Skill skill) {

    }


    @Override
    public void battleOver() {
        System.out.println("您当前状态无法执行该操作");
    }

    @Override
    public void backToScene() {
        System.out.println("您当前状态无法执行该操作");
    }

    @Override
    public void reStart() {
        System.out.println("您当前状态无法执行该操作");
    }

    @Override
    public void useItem(Item item) {

    }
}
