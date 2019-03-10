package cn.edu.nju.software.game.fighting.ui;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class GameLogPanel extends JPanel {

    private JTextArea jTextArea;

    public GameLogPanel() {
        setBorder(BorderFactory.createEtchedBorder());

        setLayout(new BorderLayout());
        JLabel jLabel = new JLabel("Log Panel");
        add(jLabel, BorderLayout.NORTH);


        jTextArea = new JTextArea("欢迎！！！\n",20,80);
        jTextArea.setLineWrap(true);
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setFont(new Font("楷体",Font.BOLD,16));
        jTextArea.setBackground(Color.WHITE);
        jTextArea.setEditable(false);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        add(jScrollPane, BorderLayout.CENTER);
    }

    public void clear(){
        jTextArea.setText("");
    }

    public void addLog(String log)
    {

//        jTextArea.append(DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd hh:mm:ss\n")+log +"\n");
        jTextArea.append(log +"\n");
        jTextArea.select(Integer.MAX_VALUE,Integer.MAX_VALUE);
    }
}
