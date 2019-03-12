package cn.edu.nju.software.game.fighting.model.role;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.role.attribute.BodyType;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.role.attribute.Race;
import cn.edu.nju.software.game.fighting.model.role.exceptions.CannotLearnException;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkill;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkillFactory;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.math.NumberUtils.min;

public class RoleFactory implements IRoleFactory{
    private static List<Role> roleList = new ArrayList<>();

    private static RoleFactory instance;

    public static RoleFactory getInstance(){
        if (instance == null) {
            instance = new RoleFactory();
        }
        return instance;
    }

    private RoleFactory(){
        AttackAbility baseAttackAbility = new AttackAbility().addPhysical(2);
        DefenseAbility baseDefenseAbility = new DefenseAbility().addPhysical(2);
        Skill skill = AttackSkillFactory.getInstance().randomSkill(Profession.NONE);
        Role role;

        role = new Role("幼年哥布林");
        add(role);
        role.setLevel(1);
        role.setBodyType(BodyType.SAMLL);
        role.setRace(Race.MONSTER);
        role.setAttackAbility(baseAttackAbility.clone());
        role.setDefenseAbility(baseDefenseAbility.clone());
        role.setBlood(10);
        role.setBloodMax(10);

        role = new Role("成年哥布林");
        add(role);
        role.setLevel(1);
        role.setBodyType(BodyType.MEDIUM);
        role.setRace(Race.MONSTER);
        role.setAttackAbility(baseAttackAbility.clone().addPhysical(3));
        role.setDefenseAbility(baseDefenseAbility.clone().addPhysical(3));
        role.setBlood(20);
        role.setBloodMax(20);

        role = new Role("大型哥布林");
        add(role);
        role.setLevel(1);
        role.setBodyType(BodyType.BIG);
        role.setRace(Race.MONSTER);
        role.setAttackAbility(baseAttackAbility.clone().addPhysical(4));
        role.setDefenseAbility(baseDefenseAbility.clone().addPhysical(4));
        role.setBlood(50);
        role.setBloodMax(50);

        role = new Role("哥布林之王");
        add(role);
        role.setLevel(1);
        role.setBodyType(BodyType.BIG);
        role.setRace(Race.MONSTER);
        role.setAttackAbility(baseAttackAbility.clone().addPhysical(7));
        role.setDefenseAbility(baseDefenseAbility.clone().addPhysical(7));
        role.setBlood(100);
        role.setBloodMax(100);

    }

    private void add(Role role){
        roleList.add(role);
    }

    @Override
    public Role getRandomRole() {
        int i = RandomUtils.nextInt(0, roleList.size());
        return roleList.get(i).clone();
    }
    public static int i = 2;
    public Role getRandomRole(Role player) {
        i--;
        Role role = null;

        while(role==null || role.getLevel() > player.getLevel()){
            role = roleList.get(RandomUtils.nextInt(0, roleList.size()));
            break;
        }

        for(int i=0; i<4; i++){
            Skill s = AttackSkillFactory.getInstance().randomSkill(Profession.NONE);
            s.addExp(Math.max((player.getLevel()-role.getLevel()), 0)*20 + RandomUtils.nextInt(1,3)*role.getAttackAbility().getPhysical(), false);
            try {
                role.learnSkill(s);
            } catch (CannotLearnException e) {

            }
        }

        if(role.getLevel() < player.getLevel()){
            role.addExp((player.getLevel()-role.getLevel()+1)*RandomUtils.nextInt(7,12)*6);
        }


        return role.clone();
    }

    @Override
    public Role getRole(Profession profession) {
        return roleList.get(0).clone();
    }
}
