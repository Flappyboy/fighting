package cn.edu.nju.software.game.fighting.model.ability;

public class RecoveryAbility extends Ability {
    private Integer blood = 0;

    public RecoveryAbility clone(){
        RecoveryAbility ability = new RecoveryAbility();
        ability.addBlood(this.blood);
        return ability;
    }

    public Integer getBlood() {
        return blood;
    }

    public RecoveryAbility addBlood(Integer blood) {
        this.blood += blood;
        return this;
    }

    public RecoveryAbility attachAbility(RecoveryAbility attach){
        addBlood(attach.getBlood());
        return this;
    }

    public static RecoveryAbility combineAbilitys(RecoveryAbility ...abilitys){
        RecoveryAbility result = new RecoveryAbility();
        for (RecoveryAbility ability:
                abilitys) {
            result.attachAbility(ability);
        }
        return result;
    }
}
