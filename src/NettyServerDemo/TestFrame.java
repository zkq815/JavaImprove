package NettyServerDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 徐飞
 * @version 2016/02/25 16:38
 */
public class TestFrame extends JFrame {

    private void hi() {
        int width = 420;
        int height = 500;
        setTitle("Server");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (screenSize.getWidth() - width) / 2, (int) (screenSize.getHeight() - height) / 2, width, height);
        setLayout(null);
        setVisible(true);
        setResizable(false);


        Button initBtn = new Button("初始化");
        initBtn.setBounds(10, 10, 50, 20);
        add(initBtn);
        initBtn.addActionListener((ActionEvent e) -> {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    PushServer.start();
                }
            });
            t1.start();
        });

        Button sendBtn = new Button("报警推送");
        sendBtn.setBounds(180, 180, 150, 20);
        add(sendBtn);
        sendBtn.addActionListener((ActionEvent e) -> {
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    PushServer.push();
                }
            });
            t2.start();
        });

        Button countBtn = new Button("暂无功能");
        countBtn.setBounds(180,70,150,20);
        add(countBtn);
        countBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t3 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                t3.start();
            }
        });
    }

    public static void main(String[] args) {
        (new TestFrame()).hi();
    }

}
