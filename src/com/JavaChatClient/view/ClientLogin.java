package com.JavaChatClient.view;

import javax.swing.*;

public class ClientLogin extends JFrame{
    JLabel j1;//定义标签组件
    JButton jb1, jb2, jb3;
    JPanel jp;

    public ClientLogin () {
        //ji=new JLabel ("JAVA 教学聊天室")://文本标签(未启用)
        j1=new JLabel (ImageLoader.load("images/head.gif"));//图片标签(已启用)
        j1.setHorizontalAlignment (SwingConstants.CENTER);//设置标签组件的水平对齐方式为居中
        
        this. add (j1, "North");//标签组件添加到窗体北部
        jb1=new JButton (ImageLoader.load("images/login.gif"));//图片按钮
        jb2=new JButton (ImageLoader.load("images/register.gif"));//注册按钮
        jb3=new JButton (ImageLoader.load("images/cancel.gif"));//取消按钮

        jp=new JPanel ();//创建面板对象
        jp.add(jb1);//在JPane1面板中添加按钮
        jp.add(jb2);//默认FlowLayout流式布局
        jp.add(jb3);//在JPane1面板中添加按钮3

        this. add (jp, "South");//JPane1组件添加到窗体南部
        //this.setBounds (800,600,350,250)://设置窗体边界(位置和大小)
        this.setLocationRelativeTo (null);//设置相对位置为null
        this.setSize (350,250);//窗体大小
        this.setDefaultCloseOperation (EXIT_ON_CLOSE);//点击窗体的关闭按钮时，退出程序
        this.setTitle("JAVA 教学聊天室");//设置窗体标题
        this.setVisible(true);//显示窗体可视化
    }

    public static void main (String[] args){
        ClientLogin cl=new ClientLogin();//创建登录窗口对象
        cl.setVisible(true);//显示窗体可视化
    }
}
