package cn.edu.nju.software.game.fighting.model.item;

import cn.edu.nju.software.game.fighting.model.ability.AttackAbility;
import cn.edu.nju.software.game.fighting.model.ability.DefenseAbility;
import cn.edu.nju.software.game.fighting.model.ability.RecoveryAbility;
import cn.edu.nju.software.game.fighting.model.item.drug.Drug;
import cn.edu.nju.software.game.fighting.model.item.equipment.EquipmentFactory;
import cn.edu.nju.software.game.fighting.model.item.intensify.IntensifyMaterialFactory;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class AllItemFactory implements IItemFactory {
    private static AllItemFactory instance;

    private static List<Item> itemList = new ArrayList<>();

    public static AllItemFactory getInstance(){
        if (instance == null) {
            instance = new AllItemFactory();
        }
        return instance;
    }

    private AllItemFactory() {
        RecoveryAbility baseRecoveryAbility = new RecoveryAbility().addBlood(10);
        Drug drug;

        drug = new Drug("初级回复药");
        drug.getRecoveryAbility().addBlood(10);
        add(drug);
        drug.setRecoveryAbility(baseRecoveryAbility.clone());

        drug = new Drug("中级回复药");
        drug.getRecoveryAbility().addBlood(30);
        add(drug);
        drug.setRecoveryAbility(baseRecoveryAbility.clone());

        drug = new Drug("高级回复药");
        drug.getRecoveryAbility().addBlood(50);
        add(drug);
        drug.setRecoveryAbility(baseRecoveryAbility.clone());

        drug = new Drug("特级回复药");
        drug.getRecoveryAbility().addBlood(100);
        add(drug);
        drug.setRecoveryAbility(baseRecoveryAbility.clone());

        itemList.addAll(EquipmentFactory.getInstance().getAllItems());
        itemList.addAll(IntensifyMaterialFactory.getInstance().getAllItems());
    }
    
    
    @Override
    public Item getRandomItem() {
        return(itemList.get(RandomUtils.nextInt(0, itemList.size()))).clone();
    }

    @Override
    public Item getItemByName(String name) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return itemList;
    }

    protected void add(Item item){
        itemList.add(item);
    }

}
