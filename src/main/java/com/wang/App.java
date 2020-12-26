package com.wang;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, AWTException {
        String content = readFile();
        String[] split = content.split("。");//内容以。未分割线
        Robot robot = new Robot();
        robot.delay(3000);//延迟三秒，主要是为了预留出打开窗口的时间
        while(true) {
            int random=(int)(Math.random()*100+1); //随机选择发送，100条消息
            String msg = split[random];
            //复制消息到剪切板
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable tText = new StringSelection(msg);
            clip.setContents(tText, null);
            //复制粘贴
            robot.keyPress( KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(500);
            robot.keyPress( KeyEvent.VK_ENTER);//回车
        }
    }
/**
 读取文件
**/	
    public static String readFile() throws IOException {
        StringBuilder result = new StringBuilder();
        FileReader fileReader = new FileReader("E:\\msg.txt"); //消息所在位置
        BufferedReader br = new BufferedReader(fileReader);
        String s  = null;
        while ((s = br.readLine())!=null){
            result.append(s);
        }
        br.close();
        return result.toString();
    }
}
