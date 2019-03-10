package cn.edu.nju.software.game.fighting.model.command.demo;

import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.ui.base.RadioColTablePanel;
import cn.edu.nju.software.game.fighting.ui.base.TextPanel;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public class RadioTableCommand extends GameCommand {
    public RadioTableCommand() {
        super("继续游戏");


        put(TextPanel.class, new TextPanel("请输入：", ""));

        Vector<Vector> data = new Vector<>();
        Vector<String> columns = new Vector<>();
        Vector<String> returnObjs = new Vector<>();
        columns.add("第一列");
        columns.add("第二列");

        Vector d1 = new Vector();
        d1.add("h1");
        d1.add("h2");
        Vector d2 = new Vector();
        d2.add("d1");
        d2.add("d2");

        returnObjs.add("第一行");
        data.add(d1);
        returnObjs.add("第2行");
        data.add(d2);
        data.add(d2);
        data.add(d2);
        data.add(d2);
        data.add(d2);
        data.add(d2);
        data.add(d2);


        put(RadioColTablePanel.class, new RadioColTablePanel(data,columns, returnObjs));
    }

    @Override
    public void Execute(Map<Object, Object> objects) {

    }


//    @Override
//    public void Execute(Object ) {
//        GameManager.getInstance().startNewGame();
//    }


}
