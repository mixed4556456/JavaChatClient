package com.JavaChatClient.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 临时验证工具：启动 FriendList 并离屏渲染保存 PNG，用于确认窗口真实布局。
 * （不依赖窗口是否在最前层）
 * 验证完可删除。
 */
public class FriendListShot {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                FriendList f = new FriendList();
                f.setLocation(0, 0);
                Timer t = new Timer(800, e -> {
                    try {
                        save(f, "friendlist_shot_card1.png");
                        // 模拟点击卡片 1 底部的“陌生人”按钮，验证事件绑定
                        f.myStrangerButton1.doClick();
                        f.validate();
                        save(f, "friendlist_shot_card2.png");
                        // 模拟点击卡片 2 顶部的“我的好友”按钮，验证切回
                        f.myFriendButton2.doClick();
                        f.validate();
                        save(f, "friendlist_shot_card1_back.png");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                });
                t.setRepeats(false);
                t.start();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(1);
            }
        });
    }

    private static void save(JFrame f, String file) throws Exception {
        int w = f.getWidth(), h = f.getHeight();
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        f.printAll(g);
        g.dispose();
        ImageIO.write(img, "png", new File(file));
        System.out.println("saved " + file + " " + w + "x" + h);
    }
}