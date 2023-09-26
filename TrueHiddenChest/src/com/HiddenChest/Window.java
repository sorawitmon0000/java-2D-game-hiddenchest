/*
        คลาสสำหรับสร้างหน้าจอเกม
 */
package com.HiddenChest;
import javax.swing.*;
import java.awt.*;

public class Window {
    //ตัวแปรสร้างหน้าจอ
    private JFrame frame;
    private String title;
    private int width,height;
    //ตัวแปร canvas
    private Canvas canvas;
    public Window(String title,int width,int height){
        this.height=height;
        this.width=width;
        this.title=title;
        createWindow();
    }
    private void createWindow(){
        frame=new JFrame(title);        //สร้างหน้าจอและใส่ชื่อ
        frame.setSize(width,height);    //กำหนดขนาดหน้าจอ
        frame.setResizable(false);      //ห้ามยืดขยายหน้าจอ
        frame.setLocationRelativeTo(null);  //เวลารันเกมหน้าต่างจะอยู่กลางจอคอม
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //เมื่อปิดหน้าต่างจะหยุดรันโปรแกรม
        frame.setVisible(true); //แสดงผลหน้าจอ
        canvas=new Canvas();    //สร้าง canvas สำหรับกราฟฟิกต่างๆ
        canvas.setPreferredSize(new Dimension(width,height));   // -
        canvas.setMaximumSize(new Dimension(width,height));     //  - - เซ็ทค่าที่จะแสดงผลกราฟฟิกจากจอ
        canvas.setMinimumSize(new Dimension(width,height));     // -
        canvas.setFocusable(false);
        frame.add(canvas); //เพิ่ม canvas ใส่ในหน้าจอเกม
        frame.pack(); //ถ้าไม่แพคจะมองไม่เห็น canvas
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public JFrame getFrame(){
        return frame;
    }
}
