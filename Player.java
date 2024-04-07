/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import main.GamePanel;
import main.KeyControl;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
    public final int screenX ;
    public final int screenY;
    public int hasKey = 0;
    
    public Player(GamePanel gp,KeyControl keyC){
        this.gp=gp;
        this.keyC=keyC;
        screenX = gp.screenWidth/2-(gp.titleSize/2);
        screenY = gp.screenHeight/2 - (gp.titleSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 12;
        solidArea.y = 20;
        solidAreaDefaultX =solidArea.x;
        solidAreaDefaultY= solidArea.y;
        solidArea.width = 24;
        solidArea.height = 28;
        
        setDefaultValue();
        getPlayerImage();
    }
    public final void setDefaultValue(){
        worldX = gp.titleSize * 23;
        worldY = gp.titleSize * 21;
        speed = 4;
        direction ="down";
    }
    public final void getPlayerImage(){
        try{
            up1 = ImageIO.read(new File("res/player/Body_Up1.png"));
            up2 = ImageIO.read(new File("res/player/Body_Up2.png"));
            down1 = ImageIO.read(new File("res/player/Body_Down1.png"));
            down2 = ImageIO.read(new File("res/player/Body_Down2.png"));
            right1 = ImageIO.read(new File("res/player/Body_Right1.png"));
            right2 = ImageIO.read(new File("res/player/Body_Right2.png"));
            left1 = ImageIO.read(new File("res/player/Body_Left1.png"));
            left2 = ImageIO.read(new File("res/player/Body_Left2.png"));
            upLeft1 = ImageIO.read(new File("res/player/Body_UpLeft1.png"));
            upLeft2 = ImageIO.read(new File("res/player/Body_UpLeft2.png"));
            downLeft1 = ImageIO.read(new File("res/player/Body_DownLeft1.png"));
            downLeft2 = ImageIO.read(new File("res/player/Body_DownLeft2.png"));
            upRight1 = ImageIO.read(new File("res/player/Body_UpRight1.png"));
            upRight2 = ImageIO.read(new File("res/player/Body_UpRight2.png"));
            downRight1 = ImageIO.read(new File("res/player/Body_DownRight1.png"));
            downRight2 = ImageIO.read(new File("res/player/Body_DownRight2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyC.down==true||keyC.left==true||keyC.right==true||keyC.up==true){
            if(keyC.up == true){
                direction = "up";
            }
            if (keyC.down == true){
                direction="down";
            }
            if (keyC.right == true){
                direction = "right";
            }
            if (keyC.left == true){
                direction = "left";
            }
            if (keyC.up == true && keyC.left ==true){
                direction = "upleft";
            }
            if(keyC.up == true && keyC.right == true){
                direction = "upright";
            }
            if(keyC.down == true && keyC.left == true){
                direction = "downleft";
            }
            if(keyC.down ==true &&keyC.right==true){
                direction = "downright";
            }
        
        // check collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        //CHECK Object collision
        int objIndex = gp.cChecker.checkObject(this,true);
        pickUpObject(objIndex);
        // if collision = false player can move
        if (collisionOn == false){
            switch(direction){
            case "up" -> worldY -= speed;
            case "down" -> worldY += speed;
            case "left" -> worldX -= speed;
            case "right" -> worldX += speed;
            case "upleft" -> {
                worldY -= speed;
                worldX -= speed;
                }
            case "upright" -> {
                worldY -= speed;
                worldX += speed;
                }
            case "downleft" -> {
                worldY += speed;
                worldX -= speed;
                }
            case "downright" -> {
                worldY += speed;
                worldX += speed;
                }
            }
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
    public void pickUpObject(int i){
        if(i !=999){
            String objectName=gp.obj[i].name;
            switch(objectName){
                case "Key" -> {
                    hasKey++;
                    gp.obj[i] = null;
                    //gp.ui.showMessage("You got a key!");
                    
                }
                case "Door" -> { 
                    if ( hasKey > 0){
                        gp.obj[i]=null;
                        hasKey--; 
                        //gp.ui.showMessage("You opened the door!");
                    }
                    else {
                        //gp.ui.showMessage("You need a key!");
                    }
                    
                /*case" Chest" ->{
                    gp.ui.gameFinished=true;
                    gp.playSE(4);
                } */
                    
                
                }
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
            case"upleft" -> {
                if(spriteNum == 1){
                    image=upLeft1;
                }
                if(spriteNum == 2){
                    image = upLeft2;
                }
            }
            case"upright" -> {
                if(spriteNum == 1){
                    image=upRight1;
                }
                if(spriteNum == 2){
                    image = upRight2;
                }
            }
            case"downright" -> {
                if(spriteNum == 1){
                    image=downRight1;
                }
                if(spriteNum == 2){
                    image = downRight2;
                }
            }
            case"downleft" -> {
                if(spriteNum == 1){
                    image=downLeft1;
                }
                if(spriteNum == 2){
                    image = downLeft2;
                }
            }
        }
        g2D.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
    }
}
