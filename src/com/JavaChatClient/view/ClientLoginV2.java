package com.JavaChatClient.view;

import java.awt.*;
import javax.swing.*;

public class ClientLoginV2 extends JFrame {
    JLabel j1;// 定义标签组件
    JButton jb1, jb2, jb3;
    JPanel jp;

    // 定义登陆界面中间部分的组件
    JLabel j11, j12, j13, j14;
    JTextField jtf;
    JPasswordField jpf;
    JButton jb4;
    JCheckBox jc1, jc2;
    JPanel jp1, jp2, jp3;
    JTabbedPane jtp;

    public ClientLoginV2() {
        // 头像（北部）：统一用 ImageLoader 加载，避免依赖启动目录
        j1 = new JLabel(ImageLoader.load("images/head.gif"));
        this.add(j1, "North");

        // 创建登陆界面中间部分的组件
        j11 = new JLabel("YY 号码：", JLabel.CENTER);
        j12 = new JLabel("YY 密码：", JLabel.CENTER);
        j13 = new JLabel("忘记密码", JLabel.CENTER);
        j13.setForeground(Color.blue);// 设置字体蓝色
        j14 = new JLabel("申请密码保护", JLabel.CENTER);
        
        jb4 = new JButton(ImageLoader.load("images/clear.gif"));
        jtf = new JTextField();//定义
        jpf = new JPasswordField();//定义
        jc1 = new JCheckBox("隐身登陆");
        jc2 = new JCheckBox("记住密码");

        jp1 = new JPanel(new GridLayout(3, 3));// 设置网格布局模式
        // 在面板中添加9个组件
        jp1.add(j11);
        jp1.add(jtf);
        jp1.add(jb4);
        jp1.add(j12);
        jp1.add(jpf);
        jp1.add(j13);
        jp1.add(jc1);
        jp1.add(jc2);
        jp1.add(j14);

        jtp = new JTabbedPane();// 创建选项卡面板
        jtp.add(jp1, "YY号码");// 在选项卡中添加3个JPane1 面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        jtp.add(jp2, "手机号码");
        jtp.add(jp3, "电子邮箱");

        this.add(jtp, "Center");// 选项卡面板添加到窗体中部
        jb1 = new JButton(ImageLoader.load("images/login.gif"));// 图片按钮
        jb2 = new JButton(ImageLoader.load("images/register.gif"));// 注册按钮
        jb3 = new JButton(ImageLoader.load("images/cancel.gif"));// 取消按钮

        jp = new JPanel();// 创建面板对象
        jp.add(jb1);// 在JPane1面板中添加按钮
        jp.add(jb2);// 默认FlowLayout流式布局
        jp.add(jb3);// 在JPane1面板中添加按钮3

        // jl=new JLabe1 ("JAVA教学聊天室")://文本标签
        this.add(jp, "South");// JPane1组件添加到窗体南部
        // this.setBounds (800,600,350,250)://设置窗体边界(位置和大小)
        this.setLocationRelativeTo(null);// 设置相对位置为null
        this.setSize(350, 250);// 窗体大小
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 点击窗体的关闭按钮时，退出程序
        this.setTitle("JAVA 教学聊天室");// 设置窗体标题
        this.setVisible(true);// 显示窗体可视化
    }

    public static void main(String[] args) {
        // 构造函数里已完成 setVisible(true)，这里只需在 EDT 上创建窗口
        SwingUtilities.invokeLater(ClientLoginV2::new);
    }
}