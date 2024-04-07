///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package main;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import object.keyObject;
//
///**
// *
// * @author LENOVO
// */
//public class UI {
//    GamePanel gp;
//    Font arial_40, arial_80B;
//    BufferedImage keyImage;
//    public boolean messageOn = false;
//    public String message = "";
//    int messageCounter =0;
//    public boolean gameFinished=false;
//    
//    public UI(GamePanel gp){
//        this.gp=gp;
//        
//        arial_40 = new Font("Arial",Font.PLAIN, 40);
//        arial_80B = new Font("Arial",Font.BOLD, 80);
//        keyObject key=new keyObject();
//        keyImage = key.image;
//    }
//    
//    public void showMessage(String text){
//        message=text;
//        messageOn=true;
//    }
//    public void draw(Graphics2D g2){
//        if(gameFinished==true) {
//            
//            g2.setFont(arial_40);
//            g2.setColor(Color.white);
//            
//            String text;
//            int textLength;
//            int x;
//            int y;
//            
//            
//            text="You found the treasure";
//            textLength =(int )g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x=gp.screenWidth/2 - textLength/2;
//            y=gp.screenHeight/2-(gp.titleSize*3);
//            g2.drawString(text,x,y);
//            
//            
//            g2.setFont(arial_80B);
//            g2.setColor(Color.yellow);
//            text="Congratulation";
//            textLength =(int )g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//            x=gp.screenWidth/2 - textLength/2;
//            y=gp.screenHeight/2+(gp.titleSize*2);
//            g2.drawString(text,x,y);
//            
//            //g2.gameThread =null;
//        }else{
//            g2.setFont(arial_40);
//            g2.setColor(Color.white);
//            g2.drawImage(keyImage, gp.titleSize/2, gp.titleSize/2, gp.titleSize,gp.titleSize,null);
//            g2.drawString("x "+gp.player.hasKey, 74,65);
//        
//            //MESSAGE
//            if(messageOn ==true) {
//            
//                g2.setFont(g2.getFont().deriveFont(30F));
//                g2.drawString(message, gp.titleSize/2, gp.titleSize*5);
//            
//                messageCounter++;
//                if(messageCounter >120){
//                    messageCounter=0;
//                    messageOn=false;
//                }
//            }
//        }
//     
//    }
//}
