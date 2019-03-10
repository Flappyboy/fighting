package cn.edu.nju.software.game.fighting.model.ability;

public class AttackAbility extends Ability{
    private Integer physical = 0;

    public AttackAbility clone(){
        AttackAbility ability = new AttackAbility();
        ability.addPhysical(this.physical);
        return ability;
    }

    public Integer getPhysical() {
        return physical;
    }

    public AttackAbility addPhysical(Integer physical) {
        this.physical += physical;
        this.physical = Math.max(0, this.physical);
        return this;
    }

    public AttackAbility attachAbility(AttackAbility attach){
        addPhysical(attach.getPhysical());
        return this;
    }

    public static AttackAbility combineAbilitys(AttackAbility ...abilitys){
        AttackAbility result = new AttackAbility();
        for (AttackAbility ability:
                abilitys) {
            result.attachAbility(ability);
        }
        return result;
    }
}
