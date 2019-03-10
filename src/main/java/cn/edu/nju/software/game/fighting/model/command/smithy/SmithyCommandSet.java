package cn.edu.nju.software.game.fighting.model.command.smithy;

import cn.edu.nju.software.game.fighting.model.command.CommandSet;
import cn.edu.nju.software.game.fighting.model.command.demo.RadioTableCommand;
import cn.edu.nju.software.game.fighting.model.command.goCommand.GoToForestCommand;

public class SmithyCommandSet extends CommandSet {

    public SmithyCommandSet() {
        super("铁匠铺");
    }

    public static SmithyCommandSet getInstance() {
        SmithyCommandSet demoCommandSet = new SmithyCommandSet();

        demoCommandSet.addCommand(new GoToForestCommand());
        demoCommandSet.addCommand(new IntensifyCommand());

        return demoCommandSet;
    }
}
