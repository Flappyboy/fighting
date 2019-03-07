package cn.edu.nju.software.game.fighting.model.ability;

public class AttackAbility {
    private Integer physical = 0;

    public AttackAbility clone(){
        AttackAbility ability = new AttackAbility();
        ability.addPhysical(this.physical);
        return ability;
    }

    public Integer getPhysical() {
        return physical;
    }

    public void addPhysical(Integer physical) {
        this.physical += physical;
    }

    public void attachAbility(AttackAbility attach){
        addPhysical(attach.getPhysical());
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
