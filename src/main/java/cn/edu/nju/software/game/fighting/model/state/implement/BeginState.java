package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

public class BeginState extends StateAdapter {
    public BeginState(Game game) {
        super(game);
    }

    @Override
    public void createRole() {
        game.say("------你已成功创建角色-------");
        game.setState(new ForestState(game));
    }
}
