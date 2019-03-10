package cn.edu.nju.software.game.fighting.model.command.UsualCommand;

import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.equipment.EquipmentList;
import cn.edu.nju.software.game.fighting.ui.base.RadioColTablePanel;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class EquipmentCommand extends GameCommand {
    public EquipmentCommand() {
        super("卸下");

        Vector<Vector> data = new Vector<>();
        Vector<String> columns = new Vector<>();
        Vector<Equipment> returnObjs = new Vector<>();
        columns.add("物品");
        columns.add("描述");

        EquipmentList equipmentList = getGame().getPlayer().getEquipmentList();
        Iterator<EquipmentType> typeIterator = equipmentList.getEquipmentTypeList(true).iterator();

        int i=0;
        while (typeIterator.hasNext()){
            EquipmentType type = typeIterator.next();
            Vector row = new Vector();
            row.add(type.getName());
            Equipment equipment = equipmentList.getEquipment(i);
            if(equipment != null){
                row.add(equipment.getName());
                row.add(equipmentList.getEquipment(i).getDesc());
            }
            data.add(row);
            returnObjs.add(equipment);
            i++;
        }

        put(Equipment.class, new RadioColTablePanel(data,columns, returnObjs));
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        Equipment equipment = (Equipment) objects.get(Equipment.class);
        if(equipment == null){
            say("请先选择装备！");
        }
        getGame().getPlayer().demountEquipment(equipment);
    }
}
