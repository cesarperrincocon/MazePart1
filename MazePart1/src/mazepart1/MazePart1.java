/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazepart1;

import com.sun.corba.se.impl.encoding.BufferManagerRead;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cesar
 */
public class MazePart1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> bricks=MazePart1.read("data/MazeMap.txt");
        
        Form window = new Form(bricks);
        window.setTitle("Maze");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private static ArrayList<String> read(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try{
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            
            while ((line = br.readLine()) != null) {
                if (line.length()==10){
                    lines.add(line);
                }else{
                    System.err.println("Error reading the .txt file");
                    System.exit(0);
                }
                
            }
            
            in.close();        
        }catch (Exception e){
            System.err.println("Error :" + e.getMessage());
        }
        
        if (lines.size()!=10){
            System.err.println("Error reading the .txt file");
            System.exit(0);
        }
        return lines;
                
    }
    
}
