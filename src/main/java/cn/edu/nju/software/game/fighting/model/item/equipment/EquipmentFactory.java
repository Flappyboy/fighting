package cn.edu.nju.software.game.fighting.model.item.equipment;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.item.IItemFactory;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.WeaponFactory;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class EquipmentFactory implements IItemFactory {
    private static EquipmentFactory instance;

    private static List<Item> equipmentList = new ArrayList<>();

    public static EquipmentFactory getInstance(){
        if (instance == null) {
            instance = new EquipmentFactory();
        }
        return instance;
    }

    private EquipmentFactory() {
        AttackAbility baseAttackAbility = new AttackAbility().addPhysical(1);
        DefenseAbility baseDefenseAbility = new DefenseAbility().addPhysical(1);
        Equipment equipment;

        equipment = new Equipment("劣质头盔",EquipmentType.HELMET);
        add(equipment);
        equipment.setDefenseAbility(baseDefenseAbility.clone().addPhysical(0));

        equipment = new Equipment("普通头盔",EquipmentType.HELMET);
        add(equipment);

        equipment.setDefenseAbility(baseDefenseAbility.clone().addPhysical(1));

        equipment = new Equipment("高级头盔",EquipmentType.HELMET);
        add(equipment);

        equipment.setDefenseAbility(baseDefenseAbility.clone().addPhysical(3));

        equipment = new Equipment("劣质戒指",EquipmentType.RING);
        add(equipment);
        equipment.setAttackAbility(baseAttackAbility.clone().addPhysical(1));
        equipment.setDefenseAbility(baseDefenseAbility.clone().addPhysical(1));

        equipment = new Equipment("普通戒指",EquipmentType.RING);
        add(equipment);
        equipment.setAttackAbility(baseAttackAbility.clone().addPhysical(1));
        equipment.setDefenseAbility(baseDefenseAbility.clone().addPhysical(2));

        equipmentList.addAll(WeaponFactory.getInstance().getAllItems());
    }

    @Override
    public Item getRandomItem() {
        return ((Equipment)equipmentList.get(RandomUtils.nextInt(0, equipmentList.size()))).clone();
    }

    @Override
    public List<Item> getAllItems() {
        return equipmentList;
    }

    protected void add(Equipment equipment){
        equipmentList.add(equipment);
    }
}
