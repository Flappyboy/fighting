package cn.edu.nju.software.game.fighting.ui.base.tablemodel;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class BaseTableModel<T> extends DefaultTableModel {

    public BaseTableModel(Vector<Vector> data, Vector<String> columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
