package cn.edu.nju.software.game.fighting.model.role;

import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.SpecificAbility;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.item.drug.Drug;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentType;
import cn.edu.nju.software.game.fighting.model.item.equipment.exection.CannotEquipmentException;
import cn.edu.nju.software.game.fighting.model.item.equipment.weapon.Weapon;
import cn.edu.nju.software.game.fighting.model.role.attribute.*;
import cn.edu.nju.software.game.fighting.model.role.bag.Bag;
import cn.edu.nju.software.game.fighting.model.role.bag.DefaultBag;
import cn.edu.nju.software.game.fighting.model.role.equipment.DefaultEquipmentList;
import cn.edu.nju.software.game.fighting.model.role.equipment.EquipmentList;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.FullEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.equipment.exception.NoEquipmentTypeException;
import cn.edu.nju.software.game.fighting.model.role.exceptions.CannotLearnException;
import cn.edu.nju.software.game.fighting.model.role.skill.DefaultSkillList;
import cn.edu.nju.software.game.fighting.model.role.skill.SkillList;
import cn.edu.nju.software.game.fighting.model.role.upgrate.DefaultUpgrateStrategy;
import cn.edu.nju.software.game.fighting.model.role.upgrate.UpgrateStrategy;
import cn.edu.nju.software.game.fighting.model.skill.ComboSkill;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkillFactory;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Role extends GameElement {

    private static final long serialVersionUID = -3512398073645067593L;
    // 桥接模式
    String id;
    Integer level = 1;
    Integer exp = 0;

    Gender gender = Gender.MALE;
    BodyType bodyType = BodyType.MEDIUM;
    Race race = Race.HUMAN;
    Profession profession = Profession.NONE;

    Integer blood = 100;
    Integer bloodMax = 100;

    Integer physical = 100;
    Integer physicalMax = 100;

    Integer mp = 100;
    Integer mpMax = 100;

    State state = State.NORMAL;

    Bag bag = new DefaultBag();
    EquipmentList equipmentList = new DefaultEquipmentList();

    SkillList skillList = new DefaultSkillList();

    AttackAbility attackAbility = new AttackAbility();
    DefenseAbility defenseAbility = new DefenseAbility();
    SpecificAbility specificAbility = new SpecificAbility();

    UpgrateStrategy upgrateStrategy = new DefaultUpgrateStrategy();

    public List<Equipment> getWeaponList(){
        List<Equipment> equipments = new ArrayList<>();
        for(Equipment equipment : equipmentList.getEquipment(EquipmentType.WEAPON)){
            equipments.add(equipment);
        }
        Iterator<Item> itemIterator = bag.iterator();
        while(itemIterator.hasNext()){
            Item item = itemIterator.next();
            if(item instanceof Weapon){
                equipments.add((Equipment) item);
            }
        }
        return equipments;
    }

    public void useDrug(Drug drug){
        this.blood += drug.getRecoveryAbility().getBlood();
        this.blood = Math.min(this.blood, this.bloodMax);
        getBag().remove(drug);
        getGame().refresh();
        getGame().useItem(drug);
    }

    @Override
    public String getDesc() {
        getGame().sayLine();
        String desc = "角色："+name+ "  等级："+getLevel()+ "  经验值："+getExp()+"  攻："+attackAbility.getPhysical()+"  防: "+defenseAbility.getPhysical();
        desc += "性别："+getGender().getName()+"  职业: "+getProfession()+"  种族: "+getRace()+"\n";
        desc += "血量："+blood+"("+bloodMax+")"+"\n";
        desc += "装备："+"\n";
        for(EquipmentType equipmentType : equipmentList.getEquipmentTypeList(false)){
            for(Equipment equipment: equipmentList.getEquipment(equipmentType)){
                desc += "     "+equipment.getDesc()+"\n";
            }
        }
        desc += "技能："+"\n";
        for(Skill skill : skillList.getSkillList()){
            desc += "     "+skill.getDesc()+"\n";
        }
        desc += "组合技："+"\n";
        for(Skill skill : getAllComoboSkills()){
            desc += "     "+skill.getDesc()+"\n";
        }
        desc += "背包: "+"\n";
        Iterator<Item> itemIterator = getBag().iterator();
        int i=6;
        while (itemIterator.hasNext() && i>0){
            i--;
            desc += "      "+itemIterator.next().getDesc()+"\n";
        }
        if(itemIterator.hasNext()){
            desc += "      .........";
        }
        getGame().sayLine();
        return desc;
    }

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
        say(getName()+" 受到了攻击  损失生命值："+hurt);
        blood -= hurt;
        if(blood<=0){
            say(getName()+" 死亡！");
            state = State.DEAD;
        }
    }

    public List<ComboSkill> getAllComoboSkills(){
        return AttackSkillFactory.getInstance().getAvalibleComboSkills(new HashSet<>(getSkillList().getSkillList()));
    }

    public void addExp(int exp){
        this.upgrateStrategy.upgrate(this, exp);
    }

    public void learnSkill(Skill skill) throws CannotLearnException {
        if(skill.getProfession().equals(this.profession) || skill.getProfession().equals(Profession.NONE) ){
            for(Skill oldskill: skillList.getSkillList()){
                if(oldskill.equals(skill)){
                    throw new CannotLearnException();
                }
            }
            if(this instanceof Player){
                say("学习了技能 "+ skill.getName()+"  "+skill.getDesc());
            }
            this.skillList.add(skill);
        }
    }

    public void forgetSkill(int index){
        this.skillList.remove(index);
    }

    public void mountEquipment(Equipment equipment){
        try {
            equipment.mount(this);
            getBag().remove(equipment);
            getGame().refresh();
            getGame().useItem(equipment);
        } catch (FullEquipmentTypeException e) {
            say(e.getMessage());
        } catch (NoEquipmentTypeException e) {
            say(e.getMessage());
        } catch (CannotEquipmentException e) {
            say(this.getProfession() + " 无法装备 " + equipment.getName());
        }
    }

    public void demountEquipment(Equipment equipment){
        equipmentList.remove(equipment);
        getBag().add(equipment);
        getGame().refresh();
    }

    public List<Item> itemDrop(){
        List<Item> itemList = new ArrayList<>();

        return itemList;
    }

    public Role clone(){
        return CloneUtils.clone( this);
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

    public UpgrateStrategy getUpgrateStrategy() {
        return upgrateStrategy;
    }

    public void setUpgrateStrategy(UpgrateStrategy upgrateStrategy) {
        this.upgrateStrategy = upgrateStrategy;
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

    public SkillList getSkillList() {
        return skillList;
    }

    public void setSkillList(SkillList skillList) {
        this.skillList = skillList;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public Integer getBloodMax() {
        return bloodMax;
    }

    public void setBloodMax(Integer bloodMax) {
        this.bloodMax = bloodMax;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        if(this.state == State.DEAD){
            return;
        }
        this.state = state;
    }

    public void enemyAutoAction(){
        List<Skill> skills = getSkillList().getSkillList();
        getGame().attack(skills.get(RandomUtils.nextInt(0,skills.size())));
    }


}
