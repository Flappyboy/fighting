package cn.edu.nju.software.game.fighting.model.command.smithy;

import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterial;
import cn.edu.nju.software.game.fighting.model.role.bag.Bag;
import cn.edu.nju.software.game.fighting.model.state.implement.SmithyState;
import cn.edu.nju.software.game.fighting.ui.base.RadioColTablePanel;
import cn.edu.nju.software.game.fighting.ui.base.TextPanel;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class IntensifyCommand extends GameCommand {
    public IntensifyCommand() {
        super("强化武器");

        List<Equipment> weaponList = getGame().getPlayer().getWeaponList();

        Vector<Vector> data = new Vector<>();
        Vector<String> columns = new Vector<>();
        Vector<Equipment> returnObjs = new Vector<>();
        columns.add("武器");
        columns.add("描述");

        for(Equipment equipment: weaponList){
            Vector vector = new Vector();
            vector.add(equipment.getName());
            vector.add(equipment.getDesc());
            data.add(vector);
            returnObjs.add(equipment);
        }

        put(Equipment.class, new RadioColTablePanel(data,columns, returnObjs));

        List<IntensifyMaterial> intensifyMaterialList = getGame().getPlayer().getBag().getIntensifyItem();

        Vector<Vector> data2 = new Vector<>();
        Vector<String> columns2 = new Vector<>();
        Vector<IntensifyMaterial> returnObjs2 = new Vector<>();
        columns2.add("强化材料");
        columns2.add("描述");

        for(IntensifyMaterial item: intensifyMaterialList){
            Vector vector2 = new Vector();
            vector2.add(item.getName());
            vector2.add(item.getDesc());
            data2.add(vector2);
            returnObjs2.add(item);
        }

        put(IntensifyMaterial.class, new RadioColTablePanel(data2,columns2, returnObjs2));
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        Equipment equipment = (Equipment) objects.get(Equipment.class);
        IntensifyMaterial intensifyMaterial = (IntensifyMaterial) objects.get(IntensifyMaterial.class);
        if(equipment == null){
            say("请选择目标武器");
            return;
        }
        if(intensifyMaterial == null){
            say("请选择强化材料");
            return;
        }
        intensifyMaterial.use(equipment);
        getGame().getPlayer().getBag().remove(intensifyMaterial);

        getGame().setState(new SmithyState(getGame()));
    }
}
