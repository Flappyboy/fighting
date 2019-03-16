package cn.edu.nju.software.game.fighting.model.command.fight;

import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.item.equipment.Equipment;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.ui.base.RadioColTablePanel;
import cn.edu.nju.software.game.fighting.ui.base.TextPanel;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class SkillCommand extends GameCommand {
    public SkillCommand() {
        super("使用技能");

        List<Skill> skillList = getGame().getPlayer().getSkillList().getSkillList();

        Vector<Vector> data = new Vector<>();
        Vector<String> columns = new Vector<>();
        Vector<Skill> returnObjs = new Vector<>();
        columns.add("武器");
        columns.add("描述");

        for(Skill skill: skillList){
            Vector vector = new Vector();
            vector.add(skill.getName());
            vector.add(skill.getDesc());
            data.add(vector);
            returnObjs.add(skill);
        }

        put(Skill.class, new RadioColTablePanel(data,columns, returnObjs));
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        Skill skill = (Skill) objects.get(Skill.class);
        if(skill == null){
            say("请选择技能！");
            return;
        }
        getGame().attack(skill);
    }


//    @Override
//    public void Execute(Object ) {
//        GameManager.getInstance().startNewGame();
//    }


}
