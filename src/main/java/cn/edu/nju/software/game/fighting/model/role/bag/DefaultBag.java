package cn.edu.nju.software.game.fighting.model.role.bag;

import cn.edu.nju.software.game.fighting.model.item.Item;
import cn.edu.nju.software.game.fighting.model.role.equipment.DefaultEquipmentList;
import cn.edu.nju.software.game.fighting.utils.CloneUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultBag implements Bag, Cloneable, Serializable {
    List<Item> itemList = new ArrayList<>();
    @Override
    public void add(Item item) {
        itemList.add(item);
    }

    @Override
    public void remove(Item item) {
        itemList.remove(item);
    }

    public void remove(String itemName) {
        int i;
        for(i=0; i<itemList.size(); i++){
            if(itemList.get(i).getName().equals(itemName)){
                break;
            }
        }
        itemList.remove(i);
    }

    public DefaultBag clone(){
        return CloneUtils.clone( this);
    }


    @Override
    public Iterator<Item> iterator() {
        return itemList.iterator();
    }

    @Override
    public void sort() {

    }
}
