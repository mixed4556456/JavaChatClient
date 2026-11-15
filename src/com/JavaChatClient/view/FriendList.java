package com.JavaChatClient.view;

import java.awt.*;          // BorderLayout / GridLayout / CardLayout 在这里
import javax.swing.*;

// 继承 JFrame 作为主窗口
public class FriendList extends JFrame {

    // ================= 定义卡片 1 (好友面板) 中的组件 =================
    JPanel friendPanel; // 卡片 1 中组件的容器
    JButton myFriendButton1;
    JButton myStrangerButton1;
    JButton blackListButton1;
    JScrollPane friendListScrollPane; // 好友列表的滚动条面板
    JPanel friendListPanel; // 好友列表面板
    final int MYFRIENDCOUNT = 50; // 50个好友
    JLabel friendLabel[] = new JLabel[MYFRIENDCOUNT]; // 定义好友图标数组

    // ================= 定义卡片 2 (陌生人面板) 中的组件 =================
    JPanel strangerPanel; // 卡片 2 中组件的容器
    JButton myFriendButton2;
    JButton myStrangerButton2;
    JButton blackListButton2;
    JScrollPane strangerListScrollPane; // 陌生人的滚动条面板
    JPanel strangerListPanel; // 陌生人列表面板
    final int STRANGERCOUNT = 20; // 20个陌生人
    JLabel strangerLabel[] = new JLabel[STRANGERCOUNT];

    public FriendList() {
        // 卡片布局：提前声明，方便下面的按钮监听器直接捕获
        CardLayout cl = new CardLayout();

        // 1. 创建卡片 1 (好友面板) 中的组件
        friendPanel = new JPanel(new BorderLayout()); // 卡片 1 设置边界布局模式

        myFriendButton1 = new JButton("我的好友");
        friendPanel.add(myFriendButton1, "North"); // 把我的好友按钮添加到卡片 1 的北部

        // 创建中间的好友列表滚动条面板
        // 好友列表面板 50 行 1 列
        friendListPanel = new JPanel(new GridLayout(MYFRIENDCOUNT, 1));
        
        for (int i = 0; i < friendLabel.length; i++) {
            // 随机生成图片路径 (假设 images 文件夹下有 0.jpg 到 5.jpg)
            String imageStr = "images/" + (int)(Math.random() * 6) + ".jpg"; 
            ImageIcon imageIcon = ImageLoader.load(imageStr);
            
            // 创建标签：显示 "i号好友" 和对应的随机头像，左对齐
            friendLabel[i] = new JLabel(i + "号好友", imageIcon, JLabel.LEFT);
            
            // 好友图标添加到好友列表面板中
            friendListPanel.add(friendLabel[i]);
        }

        // 创建滚动面板并将列表放入
        //friendListScrollPane=new JScrollPane () ; 
        //friendListscrollPane add (friendListPane1);//不能用这种方法把好友列表添加到滚动条面板
        // 注意：不能直接用 add，必须通过构造函数或 setViewportView 添加
        friendListScrollPane = new JScrollPane(friendListPanel); 
        
        // 好友滚动条添加到卡片 1 的中部
        friendPanel.add(friendListScrollPane, "Center"); 

        myStrangerButton1 = new JButton("陌生人");
        blackListButton1 = new JButton("黑名单");
        
        // 为了容纳 myStrangerButton1 和 blackListButton1 定义一个新 JPanel 面板
        // 2行 1 列的网格布局
        JPanel stranger_BlackPanel = new JPanel(new GridLayout(2, 1)); 
        
        stranger_BlackPanel.add(myStrangerButton1);
        stranger_BlackPanel.add(blackListButton1);
        
        // 添加到卡片 1 的南部
        friendPanel.add(stranger_BlackPanel, "South"); 


        // 2. 创建卡片 2 (陌生人面板) 中的组件
        strangerPanel = new JPanel(new BorderLayout());
        
        myFriendButton2 = new JButton("我的好友");
        myStrangerButton2 = new JButton("陌生人");
        
        // 为了容纳 myFriendButton2 和 myStrangerButton2 定义一个新 JPanel 面板
        // 2行 1 列的网格布局
        JPanel friend_strangerPanel = new JPanel(new GridLayout(2, 1)); 
        
        friend_strangerPanel.add(myFriendButton2);
        friend_strangerPanel.add(myStrangerButton2);
        
        // 添加到卡片 2 的北部
        strangerPanel.add(friend_strangerPanel, "North"); 

        // 创建中间的陌生人列表滚动条面板
        strangerListPanel = new JPanel(new GridLayout(STRANGERCOUNT, 1));
        
        for (int i = 0; i < strangerLabel.length; i++) {
            // 这里图片路径固定为 tortoise.gif，与上面好友列表不同
            strangerLabel[i] = new JLabel(i + "号陌生人", ImageLoader.load("images/tortoise.gif"), JLabel.LEFT);
            strangerListPanel.add(strangerLabel[i]);
        }

        strangerListScrollPane = new JScrollPane(strangerListPanel);
        // 陌生人滚动条添加到卡片 2 的中部
        strangerPanel.add(strangerListScrollPane, "Center"); 

        blackListButton2 = new JButton("黑名单");
        // 添加到卡片 2 的南部
        strangerPanel.add(blackListButton2, "South"); 


        // 3. 卡片布局（cl 已在构造函数开头创建）
        this.setLayout(cl); // 窗体设置为卡片布局
        
        // 向窗体中添加卡片
        this.add(friendPanel, "card1");
        this.add(strangerPanel, "card2");
        
        // 在窗体中显示卡片 1，默认显示卡片 1
        cl.show(this.getContentPane(), "card1");
        // cl.show(this.getContentPane(), "card2"); // 如果想默认显示卡片 2 可取消注释

        // 4. 为卡片切换按钮绑定事件
        //    卡片 1 底部“陌生人” -> 卡片 2
        myStrangerButton1.addActionListener(e -> cl.show(getContentPane(), "card2"));
        //    卡片 2 顶部“我的好友” -> 卡片 1
        myFriendButton2.addActionListener(e -> cl.show(getContentPane(), "card1"));

        // 设置窗口图标
        this.setIconImage(ImageLoader.load("images/duck2.gif").getImage());
        
        // 设置窗口基本属性（建议补充，否则窗口可能不显示）
        this.setTitle("QQ Chat");
        this.setSize(300, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FriendList();
    }
}
    