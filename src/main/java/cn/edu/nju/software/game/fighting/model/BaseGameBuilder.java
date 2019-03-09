package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.state.implement.BeginState;
import cn.edu.nju.software.game.fighting.model.state.implement.ForestState;
import cn.edu.nju.software.game.fighting.model.state.implement.SmithyState;

public abstract class BaseGameBuilder implements IGameBuilder {
    Game game = new Game("新的游戏");
    @Override
    public void buildPlayer(String name, Gender gender, Profession profession) {
        Player player = new Player();
        game.getPlayerGameElementFactory().createPlayer(player);
        game.setPlayer(player);
    }

    @Override
    public void buildState() {
        game.setInitState(new ForestState(game));
    }

    @Override
    public Game result() {
        return game;
    }
}
