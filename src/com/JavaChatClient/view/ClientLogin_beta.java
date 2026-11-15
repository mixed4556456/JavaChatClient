package com.JavaChatClient.view;

import java.net.URL;
import javax.swing.*;

public class ClientLogin_beta extends JFrame {
    JLabel j1;          // 头像标签
    JButton jb1, jb2, jb3;  // 登录、注册、取消按钮
    JPanel jp;          // 按钮面板

    public ClientLogin_beta() {
        // 加载图片（支持 classpath 和相对路径两种方式）
        ImageIcon headIcon = loadImage("images/head.gif");
        ImageIcon loginIcon = loadImage("images/login.gif");
        ImageIcon registerIcon = loadImage("images/register.gif");
        ImageIcon cancelIcon = loadImage("images/cancel.gif");
        ImageIcon backgroundIcon = loadImage("images/background.jpg");

        // 头像标签（放在窗口北部）
        j1 = new JLabel(headIcon);
        this.add(j1, "North");

        // 三个图片按钮
        jb1 = new JButton(loginIcon);
        jb2 = new JButton(registerIcon);
        jb3 = new JButton(cancelIcon);

        // 按钮面板（放在窗口南部）
        jp = new JPanel();
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        this.add(jp, "South");

        for (JButton b : new JButton[] {jb1, jb2, jb3}) {
            b.setIcon(backgroundIcon);
        }

        // 窗口设置
        this.setTitle("JAVA 教学聊天室");
        this.setSize(350, 250);
        this.setLocationRelativeTo(null);   // 居中显示
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * 加载图片——优先从 classpath 加载，失败则回退到文件路径加载
     */
    private ImageIcon loadImage(String path) {
        // 方式1：从 classpath 根目录加载（"/images/xxx.gif"）
        // 这样无论从哪个目录运行，都能找到图片
        URL url = getClass().getResource("/" + path);
        if (url != null) {
            return new ImageIcon(url);
        }
        // 方式2：从相对路径加载（运行时当前目录，原版的方式）
        ImageIcon icon = new ImageIcon(path);
        if (icon.getIconWidth() <= 0) {
            System.out.println("⚠️ 图片加载失败: " + path + "，将显示空白");
        }
        return icon;
    }

    public static void main(String[] args) {
        // 所有设置已在构造函数中完成，这里只需显示窗口
        ClientLogin_beta cl = new ClientLogin_beta();
        cl.setVisible(true);
    }
}