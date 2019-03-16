package cn.edu.nju.software.game.fighting.model.state.implement;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.item.AllItemFactory;
import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.role.Player;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.model.role.attribute.State;
import cn.edu.nju.software.game.fighting.model.skill.Skill;
import cn.edu.nju.software.game.fighting.model.state.StateAdapter;
import org.apache.commons.lang3.RandomUtils;

public class MyTurnState extends StateAdapter {
    public MyTurnState(Game game) {
        super(game);
    }

    @Override
    public void action(Skill skill) {
        skill.performs(game, game.getPlayer(), game.getEnemy());

        skill.addExp(10, true);

        if(game.getEnemy().getState().equals(State.DEAD)){
            int r = RandomUtils.nextInt(0,6);
            Role player = game.getPlayer();
            player.addExp(player.getLevel() * RandomUtils.nextInt(10,100));
            if(r == 0){
                game.say("你击杀了 "+game.getEnemy().getName()+"，但什么也没掉落");
            }else {
                game.say(game.getEnemy().getName() + " 掉落了 " + r + " 件物品: ");
                for (int i = 0; i < r; i++) {
                    Item item = AllItemFactory.getInstance().getRandomItem();
                    game.say("        " + item.getDesc());
                    game.getPlayer().getBag().add(item);
                }
            }

            game.setState(new ForestState(game));
            game.sayLine();
            return;
        }
        game.sayLine();
        game.say("进入敌方回合！");
        game.setState(new EnemyTurnState(game));
        game.getEnemy().enemyAutoAction();
    }

    @Override
    public void useItem(Item item) {
        game.say(game.getPlayer().getName()+" 使用了物品 "+item.getName());
        game.sayLine();
        game.say("进入敌方回合！");
        game.setState(new EnemyTurnState(game));
        game.getEnemy().enemyAutoAction();
    }
}
