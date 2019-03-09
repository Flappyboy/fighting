package cn.edu.nju.software.game.fighting.model.command.NewPlayerCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.IGameBuilder;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.ui.base.RadioBtnPanel;
import cn.edu.nju.software.game.fighting.ui.base.TextPanel;

import java.util.LinkedHashMap;
import java.util.Map;

public class NewPlayerCommand extends GameCommand {
    IGameBuilder gameBuilder;

    public NewPlayerCommand(IGameBuilder gameBuilder) {
        super("创建角色");
        this.gameBuilder = gameBuilder;

        put(String.class, new TextPanel("姓名："));

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
        gameBuilder.buildPlayer((String)objects.get(String.class), (Gender) objects.get(Gender.class), (Profession)objects.get(Profession.class));
        gameBuilder.buildInitItem();
        gameBuilder.buildInitSkill();
        GameManager.getInstance().startNewGame();
    }
}
