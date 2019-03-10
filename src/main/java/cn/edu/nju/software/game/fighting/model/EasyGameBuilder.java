package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.model.factory.quality.HighQualityFactory;
import cn.edu.nju.software.game.fighting.model.factory.quality.LowQualityFactory;
import cn.edu.nju.software.game.fighting.model.item.equipment.strategy.equip.BaseEquipStrategy;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.attribute.Gender;
import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;

public class EasyGameBuilder extends BaseGameBuilder {
    @Override
    public void buildPlayerGameElementFactory() {
        game.setPlayerGameElementFactory(new HighQualityFactory(game));
    }

    @Override
    public void buildEnemyGameElementFactory() {
        game.setEnemyGameElementFactory(new LowQualityFactory(game));
    }
}
