package cn.edu.nju.software.game.fighting.model.command.BuildGameCommand;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.EasyGameBuilder;
import cn.edu.nju.software.game.fighting.model.HardGameBuilder;
import cn.edu.nju.software.game.fighting.model.IGameBuilder;
import cn.edu.nju.software.game.fighting.model.NormalGameBuilder;
import cn.edu.nju.software.game.fighting.model.command.GameCommand;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.NewPlayerScenario;
import cn.edu.nju.software.game.fighting.ui.base.OperateElementPanel;
import cn.edu.nju.software.game.fighting.ui.base.RadioBtnPanel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SelectModeCommand extends GameCommand {

    public SelectModeCommand() {
        super("确认选择");

        Map<String, IGameBuilder> builderMap = new LinkedHashMap<>();
        builderMap.put("简单", new EasyGameBuilder());
        builderMap.put("标准", new NormalGameBuilder());
        builderMap.put("困难", new HardGameBuilder());
        put("mode",new RadioBtnPanel(builderMap));
    }

    @Override
    public void Execute(Map<Object, Object> objects) {
        IGameBuilder gameBuilder = (IGameBuilder) objects.get("mode");
        GameManager.getInstance().setGameBuilder(gameBuilder);
        gameBuilder.buildPlayerGameElementFactory();
        gameBuilder.buildEnemyGameElementFactory();
        GameManager.getInstance().changeScenario(NewPlayerScenario.class);
    }
}
