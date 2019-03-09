package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.model.factory.quality.HighQualityFactory;
import cn.edu.nju.software.game.fighting.model.factory.quality.LowQualityFactory;

public class HardGameBuilder extends BaseGameBuilder {
    @Override
    public void buildPlayerGameElementFactory() {
        game.setPlayerGameElementFactory(new LowQualityFactory());
    }

    @Override
    public void buildEnemyGameElementFactory() {
        game.setEnemyGameElementFactory(new HighQualityFactory());
    }

    @Override
    public void buildInitItem() {

    }

    @Override
    public void buildInitSkill() {

    }
}
