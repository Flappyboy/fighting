package cn.edu.nju.software.game.fighting;

import cn.edu.nju.software.game.fighting.model.Game;
import cn.edu.nju.software.game.fighting.model.IGameBuilder;
import cn.edu.nju.software.game.fighting.model.scenario.Scenario;
import cn.edu.nju.software.game.fighting.model.scenario.concrete.HomeScenario;
import cn.edu.nju.software.game.fighting.model.scenario.ScenarioFactory;
import cn.edu.nju.software.game.fighting.ui.GameLogPanel;
import cn.edu.nju.software.game.fighting.ui.GameOperatePanel;
import org.apache.commons.lang3.SerializationUtils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameManager {
    private static GameManager instance;

    private JFrame mainFrame;
    private GameLogPanel gameLogPanel;
    private GameOperatePanel gameOperatePanel;

    private Scenario currentScenario;

    IGameBuilder gameBuilder;

    private Game gameInstance;

    private GameManager() {
    }

    public static GameManager getInstance(){
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void start(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int WIDTH = (int)(dimension.getWidth()*(2.0/3));
        int HEIGHT = ((int)(dimension.getHeight()*(2.0/3)));
        int POSITION_X = (int)((dimension.getWidth() - WIDTH)/2);
        int POSITION_Y = (int)((dimension.getHeight() - HEIGHT)/2);

        mainFrame = new JFrame();
        mainFrame.setTitle("勇者打怪");    //设置显示窗口标题
        mainFrame.setSize(WIDTH, HEIGHT);    //设置窗口显示尺寸
        mainFrame.setLocation(POSITION_X, POSITION_Y);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints;

        mainFrame.setLayout(gridBagLayout);
        Container container=mainFrame.getContentPane();    //获取当前窗口的内容窗格

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill=GridBagConstraints.BOTH;
        gridBagConstraints.weighty=100;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridwidth=1;
        gridBagConstraints.gridheight=1;

        gameLogPanel = new GameLogPanel();
        gridBagConstraints.weightx=70;
        gridBagConstraints.gridx=0;
        container.add(gameLogPanel, gridBagConstraints);

        gameOperatePanel = new GameOperatePanel();
        gridBagConstraints.weightx=30;
        gridBagConstraints.gridx=1;
        container.add(gameOperatePanel, gridBagConstraints);

        changeScenario(HomeScenario.class);

        mainFrame.setVisible(true);    //设置窗口是否可见
    }

    public void startNewGame(){
        gameBuilder.buildState();
        gameInstance = gameBuilder.result();
        gameInstance.start();
    }

    public Game getGameInstance(){
        return gameInstance;
    }

    public Scenario changeScenario(Class<? extends Scenario> scenarioClass)
    {
        return changeScenario(scenarioClass, false);
    }
    public Scenario changeScenario(Class<? extends Scenario> scenarioClass, boolean refresh)
    {
        Scenario scenario = ScenarioFactory.getScenario(scenarioClass, refresh);
        changeScenario(scenario);
        return scenario;
    }

    private void changeScenario(Scenario scenario)
    {
        currentScenario = scenario;
//        showLog("\n  "+currentScenario.getName());
        gameOperatePanel.changeGameOperatePanel(currentScenario.getOperatePanel());
    }

    public void returnHomeScenario()
    {
        gameOperatePanel.setSelectedIndex(0);
        changeScenario(HomeScenario.class);
    }

    public GameLogPanel getGameLogPanel() {
        return gameLogPanel;
    }

    public void stop(){
        mainFrame.dispose();
        mainFrame = null;
    }

    public void exit(){
        stop();
        System.exit(0);
    }

    public void showLog(String str)
    {
        gameLogPanel.addLog(str);
    }

    public IGameBuilder getGameBuilder() {
        return gameBuilder;
    }

    public void setGameBuilder(IGameBuilder gameBuilder) {
        this.gameBuilder = gameBuilder;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public GameOperatePanel getGameOperatePanel() {
        return gameOperatePanel;
    }

    public static void main(String[] agrs)
    {
        GameManager gameManager = GameManager.getInstance();    //创建一个实例化对象
        gameManager.start();
    }

    public void continueGame() {
        if(gameInstance != null){
            gameInstance.start();
        }else{
            load();
        }
    }

    private void load(){
        File file = new File("./game");
        try {
            gameInstance = SerializationUtils.deserialize(new FileInputStream(file));
            getGameLogPanel().clear();
            gameInstance.start();
        } catch (FileNotFoundException e) {
            showLog("----------存档不存在，无法读取！-------");
        }
    }

    public void save(){
        File file = new File("./game");
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
            SerializationUtils.serialize(gameInstance, new FileOutputStream(file));
            showLog("------------保存成功------------");
        } catch (FileNotFoundException e) {
            showLog("------------保存失败------------");
        } catch (IOException e) {
            showLog("------------保存失败------------");
        }
    }
}
