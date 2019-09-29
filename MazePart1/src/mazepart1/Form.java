/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazepart1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cesar
 */
public class Form extends JFrame{
    private static final long seialVersionUID = 1L;
    private static final int BRICK_SIZE=20;
    ArrayList<String> bricks;
    
    
    public Form(ArrayList<String> bricks){
        if(!bricks.isEmpty()){
            int width=bricks.get(0).toCharArray().length*BRICK_SIZE;
            int height=bricks.size()*BRICK_SIZE;
            this.setSize(width+(3*BRICK_SIZE),height+(3*BRICK_SIZE));
        }
        
        this.bricks=bricks;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        
        Graphics2D painter = (Graphics2D) g.create();
        painter.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        painter.setColor(Color.WHITE);
        painter.fillRect(0, 0, getWidth(), getHeight());
        
        Color line = Color.GRAY.brighter();
        Color fill = Color.BLUE;
        
        int x = 0;
        int y = BRICK_SIZE+20;
        
        for (String wall : this.bricks){
            x = BRICK_SIZE+10;
            for(char c : wall.toCharArray()){
                if (c == '#'){
                    painter.setColor(fill);
                    painter.fillRect(x, y, BRICK_SIZE, BRICK_SIZE);
                    painter.setColor(line);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);
                }else{
                    painter.setColor(line);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);
                }
                x += BRICK_SIZE;
            }
            y += BRICK_SIZE;
        }
    }
}
