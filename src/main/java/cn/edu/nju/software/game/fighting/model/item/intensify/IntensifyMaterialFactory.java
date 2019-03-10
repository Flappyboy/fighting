package cn.edu.nju.software.game.fighting.model.item.intensify;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.item.IItemFactory;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.WeaponType;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class IntensifyMaterialFactory implements IItemFactory {
    private static IntensifyMaterialFactory instance;

    private static List<Item> itemList = new ArrayList<>();

    public static IntensifyMaterialFactory getInstance(){
        if (instance == null) {
            instance = new IntensifyMaterialFactory();
        }
        return instance;
    }

    private IntensifyMaterialFactory() {
        AttackAbility baseAttackAbility = new AttackAbility().addPhysical(1);
        DefenseAbility baseDefenseAbility = new DefenseAbility().addPhysical(1);
        IntensifyMaterial intensifyMaterial;

        intensifyMaterial = new IntensifyMaterial("初级强化石");
        add(intensifyMaterial);
        intensifyMaterial.setAttackAbility(baseAttackAbility.clone());

        intensifyMaterial = new IntensifyMaterial("中级强化石");
        add(intensifyMaterial);
        intensifyMaterial.setAttackAbility(baseAttackAbility.clone());

        intensifyMaterial = new IntensifyMaterial("高级强化石");
        add(intensifyMaterial);
        intensifyMaterial.setAttackAbility(baseAttackAbility.clone());
    }

    @Override
    public Item getRandomItem() {
        return((IntensifyMaterial)itemList.get(RandomUtils.nextInt(0, itemList.size()))).clone();
    }

    @Override
    public List<Item> getAllItems() {
        return itemList;
    }

    public IntensifyMaterial getInitIntensifyMaterial(){
        return (IntensifyMaterial) itemList.get(0);
    }

    protected void add(IntensifyMaterial intensifyMaterial){
        itemList.add(intensifyMaterial);
    }
}
