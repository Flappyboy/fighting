package cn.edu.nju.software.game.fighting.model.item.equipment;

import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.item.AbilityItem;
import cn.edu.nju.software.game.fighting.model.item.equipment.exection.CannotEquipmentException;
import cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip.BaseEquipStrategy;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip.IEquipStrategy;
import cn.edu.nju.software.game.fighting.model.role.attribute.State;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class Equipment extends AbilityItem {

    private static final long serialVersionUID = -3058807893771797082L;
    private EquipmentType equipmentType;

    private Profession profession = Profession.NONE;

    private IEquipStrategy equipStrategy = new BaseEquipStrategy();

    @Override
    public String getDesc() {
        String str = equipmentType.getName()+" "+super.getDesc();
        return str;
    }

    public Equipment(String name, EquipmentType equipmentType) {
        super(name);
        this.equipmentType = equipmentType;
    }

    @Override
    public void use(GameElement gameElement) {
        if(gameElement == null){
            say("此为装备物品，需指定装备对象");
        }else if(gameElement instanceof Role){
            Role role = (Role) gameElement;
            role.mountEquipment(this);
        }else{
            say("操作失败");
        }
    }

    public Equipment clone(){
        return CloneUtils.clone( this);
    }

    public void mount(Role role) throws NoEquipmentTypeException, FullEquipmentTypeException, CannotEquipmentException {
        getEquipStrategy().equip(role, this);
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public IEquipStrategy getEquipStrategy() {
        return equipStrategy;
    }

    public void setEquipStrategy(IEquipStrategy equipStrategy) {
        this.equipStrategy = equipStrategy;
    }
}
