package cn.edu.nju.software.game.fighting.model.command.NewCharacterCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.character.Character;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;

public class NewCharacterCommandSet extends CommandSet {

    public static NewCharacterCommandSet getInstance(Character character, Game game) {
        NewCharacterCommandSet homeCommandSet = new NewCharacterCommandSet();

        homeCommandSet.addCommand(new NewCharacterCommand(character, game));

        return homeCommandSet;
    }
}
