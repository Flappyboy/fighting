package cn.edu.nju.software.game.fighting.model.character;

public enum Gender {

    MALE("男"), FEMALE("女"), NONE("无");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return gender;
    }
}
