package cn.edu.nju.software.game.fighting.model.role.equipment.exception;

public class FullEquipmentTypeException extends Exception {
    public FullEquipmentTypeException() {
        super("该装备类型的槽位已满");
    }
}
