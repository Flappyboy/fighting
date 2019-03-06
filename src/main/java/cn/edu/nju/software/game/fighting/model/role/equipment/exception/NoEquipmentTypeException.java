package cn.edu.nju.software.game.fighting.model.role.equipment.exception;

public class NoEquipmentTypeException extends Exception {
    public NoEquipmentTypeException() {
        super("没有该装备的槽位");
    }
}
