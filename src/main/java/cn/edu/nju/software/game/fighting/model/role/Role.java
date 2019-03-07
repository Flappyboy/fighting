package cn.edu.nju.software.game.fighting.model.role;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.role.attribute.*;
import cn.edu.nju.software.game.fighting.model.role.bag.Bag;
import cn.edu.nju.software.game.fighting.model.role.equipment.EquipmentList;
import cn.edu.nju.software.game.fighting.model.role.skill.SkillList;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class Role extends GameElement {

    private static final long serialVersionUID = -3512398073645067593L;
    // 桥接模式
    String id;
    Integer level;
    Integer exp;

    Gender gender;
    BodyType bodyType;
    Race race;
    Profession profession;

    Integer blood;
    Integer bloodMax = 100;

    Integer physical;
    Integer physicalMax = 100;

    Integer mp;
    Integer mpMax = 100;

    State state = State.NORMAL;

    Bag bag;
    EquipmentList equipmentList;

    SkillList skillList;

    AttackAbility attackAbility;
    DefenseAbility defenseAbility;
    SpecificAbility specificAbility;



    public Role(String name) {
        super(name);
    }

    public void receiveAttack(AttackAbility attack){
        int hurt = attack.getPhysical() - this.defenseAbility.getPhysical();
        if(hurt<=-100){
            hurt = 0;
        }else if(hurt<0){
            hurt = 1;
        }
        blood -= hurt;
        if(blood<=0){
            state = State.DEAD;
        }
    }

    public void useSkill(Skill skill, Role target, Role receive){
        skill.performs(game, target, receive);
    }

    public void learnSkill(Skill skill){
        if(skill.getProfession().equals(this.profession)){
            this.skillList.add(skill);
        }
    }

    public void forgetSkill(int index){
        this.skillList.remove(index);
    }

    public void mountEquipment(Equipment equipment){
        try {
            getBag().remove(equipment);
            equipment.mount(this);
        } catch (Exception e) {
            game.say(e.getMessage());
        }
    }

    public void demountEquipment(Integer equipmentIndex){
        Equipment equipment = equipmentList.remove(equipmentIndex);
        getBag().add(equipment);
    }

    public Role clone(){
        return CloneUtils.clone( this);
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
