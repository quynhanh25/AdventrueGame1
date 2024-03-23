/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author DELL
 */
public class KeyControl implements KeyListener {
    public boolean up,down,right,left;
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
            up = true;
        }
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
            right = true;
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
            down = true;
        }
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
            left = true;
        }       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
            up = false;
        }
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
            right = false;
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
            down = false;
        }
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
            left = false;
        }  
    }
    
}
