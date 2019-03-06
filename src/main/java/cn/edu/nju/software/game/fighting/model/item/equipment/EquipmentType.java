package cn.edu.nju.software.game.fighting.model.item.equipment;

public enum EquipmentType {
    WEAPON("武器"), HELMET("头盔"), ARMOR("护甲"), RING("戒指");

    private String name;

    EquipmentType(String name) {
        this.name = name;
    }
}
