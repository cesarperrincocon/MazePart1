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
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class Form extends JFrame {

    private static final long seialVersionUID = 1L;
    private static final int BRICK_SIZE = 20;
    public int posXPerso;
    public int posYPerso;
    public int posXFinal;
    public int posYFinal;

    ArrayList<String> bricks;

    public Form(ArrayList<String> bricks, int posXPerso, int posYPerso, int posXFinal, int posYFinal) {
        if (!bricks.isEmpty()) {
            int width = bricks.get(0).toCharArray().length * BRICK_SIZE;
            int height = bricks.size() * BRICK_SIZE;
            this.setSize(width + (3 * BRICK_SIZE), height + (3 * BRICK_SIZE));
        }

        this.bricks = bricks;
        this.posXPerso = posXPerso;
        this.posYPerso = posYPerso;
        this.posXFinal = posXFinal;
        this.posYFinal = posYFinal;

    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);

        Graphics2D painter = (Graphics2D) g.create();
        painter.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        painter.setColor(Color.WHITE);
        painter.fillRect(0, 0, getWidth(), getHeight());

        Color line = Color.GRAY;
        Color muros = Color.LIGHT_GRAY;
        Color fill = Color.BLUE;
        Color text = Color.BLACK;
        Color perso = Color.RED;

        char c = 1;
        int i = 1;
        int x = 0;
        int y = BRICK_SIZE + 20;

        for (String wall : this.bricks) {

            StringTokenizer st = new StringTokenizer(wall, ",");
            painter.setColor(perso);
            painter.fillOval(posXPerso, posYPerso, 14, 14);
            char[] carray = {'F'};
            painter.drawChars(carray, 0, 1, posXFinal, posYFinal);
            x = BRICK_SIZE + 10;

            while (st.hasMoreTokens()) {
                String nombre = st.nextToken();
                if (nombre.equals("#")) {
                    painter.setColor(fill);
                    painter.fillRect(x, y, BRICK_SIZE, BRICK_SIZE);
                    painter.setColor(line);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);

                } else if (nombre.equals(".")) {
                    painter.setColor(line);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);

                } else if (nombre.equals("A")) {
                    painter.setColor(text);
                    String stringValueOf = String.valueOf((char) (c + 'A' - 1));
                    System.out.println(stringValueOf);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);
                    painter.drawString(stringValueOf, x + 7, y + 14);
                    c += 1;

                } else if (nombre.equals("B")) {
                    System.out.println(i);
                    painter.setColor(text);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);
                    painter.drawString(Integer.toString(i), x + 7, y + 14);
                    i += 1;

                } else if (nombre.equals("0")) {
                    painter.setColor(muros);
                    painter.fillRect(x, y, BRICK_SIZE, BRICK_SIZE);
                    painter.setColor(line);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);

                } else if (nombre.equals("Z")) {
                    painter.setColor(text);
                    painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);

                }
                x += BRICK_SIZE;

            }
            y += BRICK_SIZE;
        }

        String posXactuelle = null;
        switch (posXPerso) {
            case 73:
                posXactuelle = "A";
                break;
            case 93:
                posXactuelle = "B";
                break;
            case 113:
                posXactuelle = "C";
                break;
            case 133:
                posXactuelle = "D";
                break;
            case 153:
                posXactuelle = "E";
                break;
            case 173:
                posXactuelle = "F";
                break;
            case 193:
                posXactuelle = "G";
                break;
            case 213:
                posXactuelle = "H";
                break;
            case 233:
                posXactuelle = "I";
                break;
            case 253:
                posXactuelle = "J";
                break;

            default:
            // code block
        }

        String posYactuelle = null;
        switch (posYPerso) {
            case 83:
                posYactuelle = "1";
                break;
            case 103:
                posYactuelle = "2";
                break;
            case 123:
                posYactuelle = "3";
                break;
            case 143:
                posYactuelle = "4";
                break;
            case 163:
                posYactuelle = "5";
                break;
            case 183:
                posYactuelle = "6";
                break;
            case 203:
                posYactuelle = "7";
                break;
            case 223:
                posYactuelle = "8";
                break;
            case 243:
                posYactuelle = "9";
                break;
            case 263:
                posYactuelle = "10";
                break;

            default:
            // code block
        }
        painter.drawString("Position du perso : [ " + posXactuelle + " ," + posYactuelle + " ]", 350, 60);
        
        if (posXPerso == posXFinal-3 && posYPerso == posYFinal-12) {
            JFrame frame = new JFrame("showMessageDialog");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(frame, "Bien joué !!", "Victoire", JOptionPane.INFORMATION_MESSAGE);
        }
   

    }

    @Override
    protected void processKeyEvent(KeyEvent ke) {

        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (posXPerso + 20 < 13 * BRICK_SIZE) {
                posXPerso += 20;
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (posXPerso - 40 > 2 * BRICK_SIZE) {
                posXPerso -= 20;
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_UP) {
            if (posYPerso - 40 > 3 * BRICK_SIZE) {
                posYPerso -= 20;
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            if (posYPerso + 20 < 14 * BRICK_SIZE) {
                posYPerso += 20;
            }
        }
        repaint();
    }
}
