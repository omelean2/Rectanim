import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimpleGui3 {
    int xPos = 70;
    int yPos = 70;
    private JFrame frame;
    public static void main(String[] args) {
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Change colors");
        button.addActionListener((ActionEvent event) -> frame.repaint());
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            xPos++;
            yPos++;
            drawPanel.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class MyDrawPanel extends JPanel {
        Random random = new Random();
        int red;
        int green;
        int blue;


        public void paintComponent(Graphics g) {
            red = random.nextInt(256);
            green = random.nextInt(256);
            blue = random.nextInt(256);
            g.setColor(Color.WHITE);
            g.fillRect(0,0,this.getWidth(), this.getHeight());
            Color color = new Color(red, green, blue);
            g.setColor(color);
            g.fillRect(xPos, yPos, 30, 30);
        }
    }

}

