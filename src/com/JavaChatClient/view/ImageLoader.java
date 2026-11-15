package com.JavaChatClient.view;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * 统一的图片加载工具。
 * <p>
 * 优先从 classpath 加载（构建时 src/images 会被复制到 bin/images），
 * 找不到再回退到相对路径（相对当前工作目录）。
 * 这样无论从哪个目录启动，只要 classpath 里有图片就能正常显示。
 */
final class ImageLoader {

    private ImageLoader() {
    }

    /**
     * 加载图片。
     *
     * @param path 形如 "images/head.gif" 的路径
     * @return 图片对象；找不到时返回空图标并打印提示
     */
    static ImageIcon load(String path) {
        // 方式 1：classpath，"/images/xxx.gif" 中的开头的 / 表示从 classpath 根开始
        URL url = ImageLoader.class.getResource("/" + path);
        if (url != null) {
            return new ImageIcon(url);
        }

        // 方式 2：相对当前工作目录（兜底）
        ImageIcon icon = new ImageIcon(path);
        if (icon.getIconWidth() <= 0) {
            System.err.println("图片加载失败: " + path);
        }
        return icon;
    }
}