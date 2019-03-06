package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;

//战斗结束状态
public class BattleOverState extends StateAdapter {
    public BattleOverState(Game game) {
        super(game);
    }

    @Override
    public void battleOver() {
        boolean dead = false;
        //判断主角是否死亡
        if (dead) {
            game.setState(new BeginState(game));
        } else {
            game.setState(new SceneState(game));
        }
    }
}
