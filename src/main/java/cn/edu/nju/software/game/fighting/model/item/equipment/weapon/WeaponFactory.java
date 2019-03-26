package cn.edu.nju.software.game.fighting.model.item.equipment.weapon;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.item.IItemFactory;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class WeaponFactory implements IItemFactory {
    private static WeaponFactory instance;

    private static List<Item> weaponList = new ArrayList<>();

    public static WeaponFactory getInstance(){
        if (instance == null) {
            instance = new WeaponFactory();
        }
        return instance;
    }

    private WeaponFactory() {
        AttackAbility baseAttackAbility = new AttackAbility().addPhysical(1);
        DefenseAbility baseDefenseAbility = new DefenseAbility().addPhysical(1);
        Weapon weapon;
        Weapon base;

        base = new Weapon("demo", WeaponType.AXE);
        base.setAttackAbility(baseAttackAbility.clone());
        base.setProfession(Profession.WARRIOR);

        add(base, "小斧头", 0);
        add(base, "大斧头", 2);
        add(base, "板斧", 4);
        add(base, "双斧", 8);

        //剑
        base = new Weapon("demo", WeaponType.SWORD);
        base.setAttackAbility(baseAttackAbility.clone());
        base.setProfession(Profession.SWORDMAN);

        add(base, "木剑", 3);
        add(base, "铁剑", 6);
        add(base, "宝剑", 8);
        add(base, "杀剑", 10);


        //法杖
        base = new Weapon("demo", WeaponType.WAND);
        base.setAttackAbility(baseAttackAbility.clone());
        base.setProfession(Profession.MAGE);
        add(base, "劣质法杖", 1);
        add(base, "普通法杖", 2);
        add(base, "中级法杖", 5);
        add(base, "高级法杖", 15);
    }

    @Override
    public Item getRandomItem() {
        return ((Weapon)weaponList.get(RandomUtils.nextInt(0, weaponList.size()))).clone();
    }

    @Override
    public Item getItemByName(String name) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return weaponList;
    }

    public Weapon getInitWeapon(Profession profession){
        for (Item item :
                weaponList) {
            Weapon weapon = (Weapon) item;
            if(weapon.getProfession().equals(profession)){
                return weapon;
            }
        }
        return null;
    }

    protected void add(Weapon weapon){
        weaponList.add(weapon);
    }

    protected void add(Weapon base, String name, int physical){
        Weapon weapon = base.clone();
        add(weapon);
        weapon.setName(name);
        weapon.getAttackAbility().addPhysical(physical);
    }
}
