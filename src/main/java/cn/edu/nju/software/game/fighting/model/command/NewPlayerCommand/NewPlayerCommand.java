package cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.IGameBuilder;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.ui.base.RadioBtnPanel;
import cn.edu.nju.software.game.fighting.ui.base.TextPanel;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class NewPlayerCommand extends GameCommand {
    IGameBuilder gameBuilder;

    public NewPlayerCommand(IGameBuilder gameBuilder) {
        super("创建角色");
        this.gameBuilder = gameBuilder;

        put(String.class, new TextPanel("姓名：", "勇士"));

        Map<String, Gender> genderMap = new LinkedHashMap<>();
        genderMap.put(Gender.MALE.getName(), Gender.MALE);
        genderMap.put(Gender.FEMALE.getName(), Gender.FEMALE);
        put(Gender.class,new RadioBtnPanel(genderMap));

        Map<String, Profession> professionMap = new LinkedHashMap<>();
        professionMap.put(Profession.WARRIOR.getName(), Profession.WARRIOR);
        professionMap.put(Profession.SWORDMAN.getName(), Profession.SWORDMAN);
        professionMap.put(Profession.MAGE.getName(), Profession.MAGE);
        put(Profession.class,new RadioBtnPanel(professionMap));
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        String name = (String)objects.get(String.class);
        if(StringUtils.isBlank(name)){
            say("姓名非法");
            return;
        }
        if(objects.get(Gender.class)==null){
            say("请选择性别");
        }
        if(objects.get(Profession.class)==null){
            say("请选择职业");
        }
        gameBuilder.buildPlayer(name, (Gender) objects.get(Gender.class), (Profession)objects.get(Profession.class));
        gameBuilder.buildInitItem();
        gameBuilder.buildInitSkill();
        GameManager.getInstance().startNewGame();
    }
}
