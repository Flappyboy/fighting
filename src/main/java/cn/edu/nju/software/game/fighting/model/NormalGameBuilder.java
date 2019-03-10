package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.model.factory.quality.NormalQualityFactory;

public class NormalGameBuilder extends BaseGameBuilder {

    @Override
    public void buildPlayerGameElementFactory() {
        game.setPlayerGameElementFactory(new NormalQualityFactory(game));
    }

    @Override
    public void buildEnemyGameElementFactory() {
        game.setEnemyGameElementFactory(new NormalQualityFactory(game));
    }
}
