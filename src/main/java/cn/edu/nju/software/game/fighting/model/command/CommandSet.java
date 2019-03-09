package cn.edu.nju.software.game.fighting.model.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CommandSet {

    private String name;

    public CommandSet(String name) {
        this.name = name;
    }

    List<ICommand> commandList = new ArrayList<>();

    public void addCommand(ICommand command){
        commandList.add(command);
    }

    public Iterator<ICommand> getCommandIterator(){
        return commandList.iterator();
    }

    public String getName() {
        return name;
    }
}
