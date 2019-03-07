package cn.edu.nju.software.game.fighting.model.ability;

public class DefenseAbility {
    private Integer physical = 0;

    public DefenseAbility clone(){
        DefenseAbility ability = new DefenseAbility();
        ability.addPhysical(this.physical);
        return ability;
    }

    public Integer getPhysical() {
        return physical;
    }

    public void addPhysical(Integer physical) {
        this.physical += physical;
    }

    public void attachAbility(DefenseAbility attach){
        addPhysical(attach.getPhysical());
    }

    public static DefenseAbility combineAbilitys(DefenseAbility ...abilitys){
        DefenseAbility result = new DefenseAbility();
        for (DefenseAbility ability:
                abilitys) {
            result.attachAbility(ability);
        }
        return result;
    }
}
