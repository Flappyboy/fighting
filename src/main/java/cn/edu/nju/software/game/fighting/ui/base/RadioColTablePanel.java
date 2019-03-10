package cn.edu.nju.software.game.fighting.ui.base;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.ui.base.tablemodel.BaseTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int s = table.getSelectedRow();
                if(s>=0){
                    if(returnObjs.get(s) instanceof GameElement){
                        GameManager.getInstance().showLog(((GameElement)returnObjs.get(s)).getDesc());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

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
