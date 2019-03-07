package cn.edu.nju.software.game.fighting.model.role.attribute;

import cn.edu.nju.software.game.fighting.model.role.Role;

import java.util.ArrayList;
import java.util.List;

public enum State {
    NORMAL("正常", new StateFeedback() {
        @Override
        public void feedBack(Role role) {

        }
    }),
    DEAD("死亡", new StateFeedback() {
        @Override
        public void feedBack(Role role) {

        }
    }),
    DAZZLE("眩晕", new StateFeedback() {
        @Override
        public void feedBack(Role role) {

        }
    }),
    POISON("中毒", new StateFeedback() {
        @Override
        public void feedBack(Role role) {

        }
    });

    private String name;
    StateFeedback stateFeedback;

    State(String name, StateFeedback stateFeedback) {
        this.name = name;
        this.stateFeedback = stateFeedback;
    }

    public static List<State> allState(){
        List<State> stateList = new ArrayList<>();
        stateList.add(DAZZLE);
        stateList.add(POISON);
        return stateList;
    }

    interface StateFeedback {
        void feedBack(Role role);
    }
}
