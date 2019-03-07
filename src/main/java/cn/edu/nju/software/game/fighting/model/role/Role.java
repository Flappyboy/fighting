package cn.edu.nju.software.game.fighting.model.role;

//Bridge pattern

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.role.attribute.BodyType;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.role.attribute.Race;
import cn.edu.nju.software.game.fighting.model.role.bag.Bag;
import cn.edu.nju.software.game.fighting.model.role.equipment.EquipmentList;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;

public class Role {

    // 桥接模式
    String id;
    String name;
    Integer level;
    Integer exp;

    Gender gender;
    BodyType bodyType;
    Race race;
    Profession profession;

    Bag bag;
    EquipmentList equipmentList;

    AttackAbility attackAbility;
    DefenseAbility defenseAbility;
    SpecificAbility specificAbility;

    public void equip(Equipment equipment){

    }

    public Game getGame(){
        return GameManager.getInstance().getGameInstance();
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public EquipmentList getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(EquipmentList equipmentList) {
        this.equipmentList = equipmentList;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public AttackAbility getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(AttackAbility attackAbility) {
        this.attackAbility = attackAbility;
    }

    public DefenseAbility getDefenseAbility() {
        return defenseAbility;
    }

    public void setDefenseAbility(DefenseAbility defenseAbility) {
        this.defenseAbility = defenseAbility;
    }

    public SpecificAbility getSpecificAbility() {
        return specificAbility;
    }

    public void setSpecificAbility(SpecificAbility specificAbility) {
        this.specificAbility = specificAbility;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
