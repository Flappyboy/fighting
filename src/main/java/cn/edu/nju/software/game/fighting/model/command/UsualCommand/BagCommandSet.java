package cn.edu.nju.software.game.fighting.model.command.UsualCommand;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;

public class BagCommandSet extends CommandSet {

    public BagCommandSet() {
        super("Demo");
    }

    public static BagCommandSet getInstance() {
        BagCommandSet bagCommandSet = new BagCommandSet();

        bagCommandSet.addCommand(new BagCommand());

        return bagCommandSet;
    }
}
