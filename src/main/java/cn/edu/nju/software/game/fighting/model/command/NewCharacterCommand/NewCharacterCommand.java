package cn.edu.nju.software.game.fighting.model.command.NewCharacterCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.character.ICharacter;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

import javax.swing.*;

public class NewCharacterCommand implements ICommand {

    ICharacter character;
    Game game;

    public NewCharacterCommand(ICharacter character, Game game) {
        this.character = character;
        this.game = game;
    }

    @Override
    public String getCommandName() {
        return "创建角色";
    }

    @Override
    public void Execute() {
        game.createNewCharacter(character);
    }
}
