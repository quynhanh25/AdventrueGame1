/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author DELL
 */
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
        getImageTile();
        loadMap();
    }
    public final void getImageTile(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("res/title/grass.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("res/title/water01.png"));
            tile[2].collision = true;
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("res/title/wall.png"));
            tile[1].collision=true;
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("res/title/earth.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File("res/title/tree.png"));
            tile[4].collision = true;
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File("res/title/road00.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public final void loadMap(){
        try {
            FileInputStream fis = new FileInputStream("res/map/world01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
            int row = 0,col = 0;
            while (col<gp.maxWorldCol&&row<gp.maxWorldRow){
                String line = br.readLine();
                while(col<gp.maxWorldCol){
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col==gp.maxWorldCol){
                    col = 0;
                    row++;
                }
                
            }
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2D){
        int worldCol =0,worldRow=0;
        
        while(worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow){
            int tileNum  = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.titleSize;
            int worldY = worldRow * gp.titleSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            if (worldX + gp.titleSize > gp.player.worldX - gp.player.screenX &&
                worldY - gp.titleSize < gp.player.worldY + gp.player.screenY &&
                worldX - gp.titleSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.titleSize > gp.player.worldY - gp.player.screenY)
            {
                g2D.drawImage(tile[tileNum].image, screenX, screenY,gp.titleSize,gp.titleSize, null);
            }
            worldCol++;
            if (worldCol == gp.maxWorldCol){
                worldCol=0;
                worldRow++;
            }
        }
    }
}
