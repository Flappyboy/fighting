package cn.edu.nju.software.game.fighting.model.state;

public interface State {

    public void createRole();

    //访问铁匠铺
    public void visitSmithy();

    //退出铁匠铺
    public void exitSmithy();

    //森林转转
    public void randomEnemy();

    //我方回合前向回合转移
    public void prepareBeforeMyTurn();


    public void prepareBeforeEnemyTurn();

    public void action();

    //战斗结束
    public void battleOver();

    //返回森林场景
    public void backToScene();

    //重新创建角色
    public void reStart();
}
