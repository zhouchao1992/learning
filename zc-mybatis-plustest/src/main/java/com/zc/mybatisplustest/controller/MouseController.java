package com.zc.mybatisplustest.controller;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseController implements Runnable {

    private Robot robot;
    private boolean isStop = false;

    public MouseController() {
        try {
            ControllerFrame frame = new ControllerFrame("Prevent Locking");
            frame.setVisible(true);
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int x;
        int y;
        Random random = new Random();
        while (!isStop) {
            //随机生成坐标。
            x = random.nextInt(1000);
            y = random.nextInt(1000);
            //开始移动
            robot.mouseMove(x, y);
            //每5秒移动一次
            robot.delay(6000);
        }

    }

    /**
     * GUI Frame 生成一个button，控制程序
     * @author max
     *
     */
    private class ControllerFrame extends JFrame {
        private static final long serialVersionUID = 1L;

        private JButton close = new JButton("close");

        public ControllerFrame(String title) {
            this();
            setTitle(title);
        }

        public ControllerFrame() {
            setLayout(new FlowLayout(FlowLayout.LEADING));
            setSize(316, 338);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            Dimension preferredSize = new Dimension(300,300);
            Font font = new Font("", 1, 80);

            //设置button 大小，文字等属性
            close.setPreferredSize(preferredSize);
            close.setFont(font);
            close.setBorderPainted(true);
            close.setFocusable(false);

            add(close);

            //点击button后，程序终止。
            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isStop = true;
                    dispose();
                }
            });

        }

    }

    public static void main(String[] args) {
        MouseController m = new MouseController();
        m.run();
    }
}