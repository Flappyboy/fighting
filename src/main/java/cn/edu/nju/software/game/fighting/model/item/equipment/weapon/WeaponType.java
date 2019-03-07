package cn.edu.nju.software.game.fighting.model.item.equipment.weapon;

import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;

import java.util.HashSet;
import java.util.Set;

public enum WeaponType {
    AXE("斧子", null),
    SWORD("剑", new HashSet<Profession>(){{
        add(Profession.WARRIOR);
        add(Profession.SWORDMAN);
    }}),
    WAND("法杖",new HashSet<Profession>(){{
        add(Profession.MAGE);
    }});

    private String name;

    /**
     * 支持的职业，最终是否可以装备还需要相应的装备策略支持
     */
    private Set<Profession> supportProfessionSet = null;

    WeaponType(String name, Set<Profession> supportProfessionSet) {
        this.name = name;
        this.supportProfessionSet = supportProfessionSet;
    }

    public boolean isSupported(Profession profession){
        if(supportProfessionSet == null){
            return true;
        }
        return supportProfessionSet.contains(profession);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
