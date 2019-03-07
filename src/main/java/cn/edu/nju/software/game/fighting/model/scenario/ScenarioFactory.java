package cn.edu.nju.software.game.fighting.model.scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioFactory {

    private static final Map<Class<? extends SharedScenario>, SharedScenario> scenarioMap = new HashMap<>();

    public static Scenario getScenario(Class<? extends Scenario> scenarioClass)
    {
        if(SharedScenario.class.isAssignableFrom(scenarioClass)){
            return getSharedScenario(scenarioClass);
        }else{
            return getUnsharedScenario(scenarioClass);
        }
    }

    public static SharedScenario getSharedScenario(Class scenarioClass) {
        SharedScenario scenario = scenarioMap.get(scenarioClass);

        if(scenario == null) {
            try {
                scenario = (SharedScenario) scenarioClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            scenarioMap.put(scenarioClass, scenario);
        }
        return scenario;
    }

    public static UnsharedScenario getUnsharedScenario(Class scenarioClass) {
        UnsharedScenario scenario = null;
            try {
                scenario = (UnsharedScenario) scenarioClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return scenario;
    }
}
