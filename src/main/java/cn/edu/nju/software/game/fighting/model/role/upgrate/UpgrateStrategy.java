package cn.edu.nju.software.game.fighting.model.role.upgrate;

import cn.edu.nju.software.game.fighting.model.role.Role;

public interface UpgrateStrategy {

    void upgrate(Role role, int incrementExp);
}
