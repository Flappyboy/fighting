package cn.edu.nju.software.game.fighting.model.command.UsualCommand;

import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.ui.base.RadioColTablePanel;
import cn.edu.nju.software.game.fighting.ui.base.TextPanel;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class BagCommand extends GameCommand {
    public BagCommand() {
        super("装备/使用");

        Vector<Vector> data = new Vector<>();
        Vector<String> columns = new Vector<>();
        Vector<Item> returnObjs = new Vector<>();
        columns.add("物品");
        columns.add("描述");

        Iterator<Item> itemIterator = game.getPlayer().getBag().iterator();

        while (itemIterator.hasNext()){
            Item item = itemIterator.next();
            Vector row = new Vector();
            row.add(item.getName());
            row.add(item.getDesc());
            data.add(row);
            returnObjs.add(item);
        }

        put(Item.class, new RadioColTablePanel(data,columns, returnObjs));
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        Item item = (Item) objects.get(Item.class);
        item.use();
    }


//    @Override
//    public void Execute(Object ) {
//        GameManager.getInstance().startNewGame();
//    }


}
