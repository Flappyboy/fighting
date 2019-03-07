package cn.edu.nju.software.game.fighting.model.item.equipment.weapon;

public enum WeaponType {
    AXE("斧子"), SWORD("剑"), WAND("法杖");

    private String name;

    WeaponType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
