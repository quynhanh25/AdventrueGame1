/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import Entity.Player;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import tile.TileManager;
/**
 *
 * @author DELL
 */
public class GamePanel extends JPanel implements Runnable {
    //screen setting
    public final int originalTitleSize = 16;
    public final int scale = 3;
    
    final public int titleSize = originalTitleSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * titleSize;
    public final int screenHeight = maxScreenRow * titleSize;
    
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = maxWorldCol * titleSize;
    public final int worldHeight = maxWorldRow * titleSize;
    //FPS
    final int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    KeyControl keyC = new KeyControl();
    Thread gameThread ;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this,keyC);
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyC);
        this.setFocusable(true);
    }
    
    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        // 1000000000 nano giay tren 1 toc do khung hinh
        double drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long currentTime;
        double delta = 0;
        long timer = 0;
        double fps = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1){
                //Cap nhat thong tin vi tri nhan vat
                update();
                //Ve lai nhan vat o vi tri moi
                repaint();
                delta--;
                fps++;
            }
            if (timer >= 1000000000){
                System.out.println("FPS: "+fps);
                timer = 0;
                fps = 0;
            }
        }
    }
    public void update(){
        player.update();
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D) g;
        
        tileM.draw(g2D);
        player.draw(g2D);
        
        g2D.dispose();
    }
}
