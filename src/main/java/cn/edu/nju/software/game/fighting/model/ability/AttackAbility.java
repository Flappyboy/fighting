package cn.edu.nju.software.game.fighting.model.ability;

public class AttackAbility {
    private Integer physical = 0;

    public Integer getPhysical() {
        return physical;
    }

    public void addPhysical(Integer physical) {
        this.physical += physical;
    }
}
