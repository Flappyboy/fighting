package cn.edu.nju.software.game.fighting.model.item.drug;

import cn.edu.nju.software.game.fighting.model.GameElement;
import cn.edu.nju.software.game.fighting.model.item.AbilityItem;
import cn.edu.nju.software.game.fighting.model.role.Role;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

public class Drug extends AbilityItem {

    public Drug(String name) {
        super(name);
    }

    public Drug clone(){
        return CloneUtils.clone( this);
    }

    @Override
    public void use(GameElement target) {
        if(target == null){
            say("此为药品，需要指定目标！");
        }else if(target instanceof Role){
            Role role = (Role) target;
            role.useDrug(this);
        }
    }
}
