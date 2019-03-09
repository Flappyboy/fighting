package cn.edu.nju.software.game.fighting.model;

import cn.edu.nju.software.game.fighting.GameManager;
import cn.edu.nju.software.game.fighting.model.factory.quality.NormalQualityFactory;
import cn.edu.nju.software.game.fighting.model.skill.SkillFactory;
import cn.edu.nju.software.game.fighting.model.skill.attack.AttackSkillFactory;

public class NormalGameBuilder extends BaseGameBuilder {

    @Override
    public void buildPlayerGameElementFactory() {
        game.setPlayerGameElementFactory(new NormalQualityFactory());
    }

    @Override
    public void buildEnemyGameElementFactory() {
        game.setEnemyGameElementFactory(new NormalQualityFactory());
    }

    @Override
    public void buildInitItem() {

    }

    @Override
    public void buildInitSkill() {
        game.getPlayer().learnSkill(game.getPlayerGameElementFactory().createSkill(AttackSkillFactory.getInstance().randomSkill(game.getPlayer().getProfession())));
    }
}
