package cn.edu.nju.software.game.fighting.model.role;

import cn.edu.nju.software.game.fighting.model.role.attribute.Profession;

public interface IRoleFactory {

    Role getRandomRole();

    Role getRole(Profession profession);
}
