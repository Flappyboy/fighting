package cn.edu.nju.software.game.fighting.model.command.NewCharacterCommand;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.character.ICharacter;
import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.ContinueGameCommand;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.GameInfoCommand;
import cn.edu.nju.software.game.fighting.model.command.HomeCommand.NewGameCommand;

public class NewCharacterCommandSet extends CommandSet {

    public static NewCharacterCommandSet getInstance(ICharacter character, Game game) {
        NewCharacterCommandSet homeCommandSet = new NewCharacterCommandSet();

        homeCommandSet.addCommand(new NewCharacterCommand(character, game));

        return homeCommandSet;
    }
}
