package cn.edu.nju.software.game.fighting.model.state;

import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.skill.Skill;

public interface State {

    public void createRole();

    //访问铁匠铺
    public void visitSmithy();

    //退出铁匠铺
    public void visitForest();

    //森林转转
    public void randomEnemy();

    public void action(Skill skill);

    //战斗结束
    public void battleOver();

    //返回森林场景
    public void backToScene();

    //重新创建角色
    public void reStart();

    public void useItem(Item item);
}
