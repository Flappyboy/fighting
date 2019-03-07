package cn.edu.nju.software.game.fighting.model.role;

import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class Player extends Role {

    public Player() {
        super("未命名");
    }

    public Player clone(){
        return CloneUtils.clone( this);
    }
}
