package cn.edu.nju.software.game.fighting.ui.base;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.ui.base.tablemodel.BaseTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class RadioColTablePanel<T> extends OperateElementPanel{

    BaseTableModel<T> baseTableModel;
    JScrollPane scroll;
    JTable table;
    Vector<T> returnObjs;
    int[] widths = {40, 80, 80};
    public RadioColTablePanel(Vector<Vector> data, Vector<String> columnNames, Vector<T> returnObjs) {
        this.returnObjs= returnObjs;
        baseTableModel = new BaseTableModel<T>(data, columnNames);
        table = new JTable(baseTableModel);

        for(int i=0; i<columnNames.size(); i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
        }

        scroll = new JScrollPane(table){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(GameManager.getInstance().getGameOperatePanel().getWidth()*7/10, GameManager.getInstance().getMainFrame().getHeight()/5);
            }
        };
        scroll.setViewportView(table);
        add(scroll);
}

    @Override
    public T getData() {
        int s = table.getSelectedRow();
        if(s<0){
            return null;
        }
        return returnObjs.get(s);
    }
}
