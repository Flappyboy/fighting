package cn.edu.nju.software.game.fighting.model.command.NewCharacterCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.character.Character;
import cn.edu.nju.software.game.fighting.model.command.ICommand;

public class NewCharacterCommand implements ICommand {

    Character character;
    Game game;

    public NewCharacterCommand(Character character, Game game) {
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
