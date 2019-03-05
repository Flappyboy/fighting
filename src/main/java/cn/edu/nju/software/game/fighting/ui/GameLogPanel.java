package cn.edu.nju.software.game.fighting.ui;

import javax.swing.*;
import java.awt.*;

public class GameLogPanel extends JPanel {

    private JTextArea jTextArea;

    public GameLogPanel() {
        setBorder(BorderFactory.createEtchedBorder());

        setLayout(new BorderLayout());
        JLabel jLabel = new JLabel("Log Panel");
        add(jLabel, BorderLayout.NORTH);


        jTextArea = new JTextArea("游戏开始\n",20,80);
        jTextArea.setLineWrap(true);
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setFont(new Font("楷体",Font.BOLD,16));
        jTextArea.setBackground(Color.WHITE);
        jTextArea.setEditable(false);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        add(jScrollPane, BorderLayout.CENTER);
    }

    public void addLog(String log)
    {
        jTextArea.append(log+"\n");
    }
}
