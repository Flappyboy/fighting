package cn.edu.nju.software.game.fighting.model.role;

public enum Gender {

    MALE("男"), FEMALE("女"), NONE("无");

    private String name;

    Gender(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
