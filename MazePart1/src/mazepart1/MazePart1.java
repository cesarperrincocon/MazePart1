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
import javax.swing.JOptionPane;

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
        String firstNumber = JOptionPane.showInputDialog("Input Horizontal (A-J) :");
        String secondNumber = JOptionPane.showInputDialog("Input Vertical (1-10) :");
        int num1 = 0;
        switch (firstNumber) {
            case "A":
                num1 = 73;
                break;
            case "B":
                num1 = 93;
                break;
            case "C":
                num1 = 113;
                break;
            case "D":
                num1 = 133;
                break;
            case "E":
                num1 = 153;
                break;
            case "F":
                num1 = 173;
                break;
            case "G":
                num1 = 193;
                break;
            case "H":
                num1 = 213;
                break;
            case "I":
                num1 = 233;
                break;
            case "J":
                num1 = 253;
                break;

            default:
            // code block
        }
        int num2 = Integer.parseInt(secondNumber);
        switch (num2) {
            case 1:
                num2 = 83;
                break;
            case 2:
                num2 = 103;
                break;
            case 3:
                num2 = 123;
                break;
            case 4:
                num2 = 143;
                break;
            case 5:
                num2 = 163;
                break;
            case 6:
                num2 = 183;
                break;
            case 7:
                num2 = 203;
                break;
            case 8:
                num2 = 223;
                break;
            case 9:
                num2 = 243;
                break;
            case 10:
                num2 = 263;
                break;

            default:
            // code block
        }
        String sum = firstNumber + secondNumber;
        JOptionPane.showMessageDialog(null, "Position is : " + sum, "Initial position", JOptionPane.PLAIN_MESSAGE);

        String posxfinal = JOptionPane.showInputDialog("Input Horizontal (A-J) :");
        String posyfinal = JOptionPane.showInputDialog("Input Vertical (1-10) :");
        int num3 = 0;
        switch (posxfinal) {
            case "A":
                num3 = 73;
                break;
            case "B":
                num3 = 93;
                break;
            case "C":
                num3 = 113;
                break;
            case "D":
                num3 = 133;
                break;
            case "E":
                num3 = 153;
                break;
            case "F":
                num3 = 173;
                break;
            case "G":
                num3 = 193;
                break;
            case "H":
                num3 = 213;
                break;
            case "I":
                num3 = 233;
                break;
            case "J":
                num3 = 253;
                break;

            default:
            // code block
        }
        int num4 = Integer.parseInt(posyfinal);
        switch (num4) {
            case 1:
                num4 = 83;
                break;
            case 2:
                num4 = 103;
                break;
            case 3:
                num4 = 123;
                break;
            case 4:
                num4 = 143;
                break;
            case 5:
                num4 = 163;
                break;
            case 6:
                num4 = 183;
                break;
            case 7:
                num4 = 203;
                break;
            case 8:
                num4 = 223;
                break;
            case 9:
                num4 = 243;
                break;
            case 10:
                num4 = 263;
                break;

            default:
            // code block
        }
        String sum2 = posxfinal + posyfinal;
        JOptionPane.showMessageDialog(null, "Final Position is : " + sum2, "Initial position", JOptionPane.PLAIN_MESSAGE);
        ArrayList<String> bricks = MazePart1.read("data/MazeMap.txt");

        Form window = new Form(bricks, num1, num2, num3+3,num4+12);
        window.setTitle("Maze");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    static ArrayList<String> read(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.length() != 26) {
                    lines.add(line);
                } else {
                    System.err.println("Incorect lenght in the .txt file");
                    System.err.println(line.length());
                    System.exit(0);
                }

            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error :" + e.getMessage());
        }

        if (lines.size() != 13) {
            System.err.println("Incorrect number of lines in the .txt file");
            System.exit(0);
        }
        return lines;

    }

}
