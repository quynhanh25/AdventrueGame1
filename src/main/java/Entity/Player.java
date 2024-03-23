/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import main.GamePanel;
import main.KeyControl;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class Player extends Entity {
    GamePanel gp;
    KeyControl keyC;
    public Player(GamePanel gp,KeyControl keyC){
        this.gp=gp;
        this.keyC=keyC;
        setDefaultValue();
        getPlayerImage();
    }
    public final void setDefaultValue(){
        x = 100;
        y = 100;
        speed = 4;
        direction ="down";
    }
    public final void getPlayerImage(){
        try{
            up1 = ImageIO.read(new File("player/bodyup_1.png"));
            up2 = ImageIO.read(new File("player/bodyup_2.png"));
            down1 = ImageIO.read(new File("player/bodydown_1.png"));
            down2 = ImageIO.read(new File("player/bodydown_2.png"));
            right1 = ImageIO.read(new File("player/bodyright_1.png"));
            right2 = ImageIO.read(new File("player/bodyright_2.png"));
            left1 = ImageIO.read(new File("player/bodyleft_1.png"));
            left2 = ImageIO.read(new File("player/bodyleft_2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyC.down==true||keyC.left==true||keyC.right==true||keyC.up==true){
            if(keyC.up == true){
            direction = "up";
            y -= speed;
        }
        if (keyC.down == true){
            direction="down";
            y += speed;
        }
        if (keyC.right == true){
            direction = "right";
            x += speed;
        }
        if (keyC.left == true){
            direction = "left";
            x -= speed;
        }
        spriteCount ++;
        if (spriteCount>12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum=1;
            }
            spriteCount=0;
        }
      }
        
    }
    public void draw(Graphics2D g2D){
//        g2D.setColor(Color.red);
//        
//        g2D.fillRect(x, y , gp.titleSize, gp.titleSize);
        BufferedImage image = null;
        switch (direction){
            case "up" -> {
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
            }
            case"down" ->{ 
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image= down2;
                }
            }
                
            case"right" ->{
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
            }
            case"left" ->{
                if(spriteNum == 1){
                    image=left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
            }
        }
        g2D.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);
    }
}
