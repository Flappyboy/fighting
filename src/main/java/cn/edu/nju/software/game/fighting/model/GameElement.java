package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.GameManager;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public abstract class GameElement implements Serializable, Cloneable {
    protected transient Game game;

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc(){
        return name;
    }

    public GameElement(String name) {
        this.name = name;
        game = GameManager.getInstance().getGameInstance();
        if(game == null){
            if(GameManager.getInstance().getGameBuilder()!=null){
                game = GameManager.getInstance().getGameBuilder().result();
            }
        }
    }

    public void say(String log){
        GameManager.getInstance().showLog(log);
    }

    public Game getGame() {
        if(game == null) {
            return GameManager.getInstance().getGameInstance();
        }else{
            return game;
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameElement that = (GameElement) o;
        return new EqualsBuilder()
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }


}
