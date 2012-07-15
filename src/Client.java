import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client {
  Color gratzColor = new Color(255, 255, 255);
  Color scoreColor = new Color(50, 255, 255);
  
  Color bgColor = new Color(15,76,32);
  
  MyGame game = new MyGame();

  private BufferedImage img;

  int counter = 0;
  JButton attack = new JButton("Attack!");
  JButton runaway = new JButton("Run Away!");
  
  JPanel paneel = new JPanel() {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g.create();
      try {
       
        g2.setColor(bgColor);
        g2.fillRect(0, 0, paneel.getWidth(), paneel.getHeight());

        g2.drawImage(img, 0, 0, null);

        //g2.drawLine(10+counter*30, 10+counter*10, 100+counter*20, 20+counter*10);

        g2.setColor(scoreColor);
        g2.setFont(attack.getFont().deriveFont(Font.BOLD).deriveFont(18f));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("Monster's Health: " + game.getStats().getHealth() + "HP", 10, 20);
        g2.drawString("Monster's Armor: " + game.getStats().getArmor() + "%", 10, 40);

        if (game.gameOver == true) {
          g2.setColor(gratzColor);
          g2.drawString("You killed the monster! Well done!", 250, 450);
          attack.setEnabled(false);
        }

      } finally {
        g2.dispose();
      }
    };
  };

  void ava() {
    JFrame frame = new JFrame("TxtADV");
    

    try {
        img = ImageIO.read(new File("img/background.jpg"));
    } catch (IOException e) {
    
    }

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(paneel);
    paneel.setLayout(new BorderLayout());
    paneel.add(attack, BorderLayout.SOUTH);

    attack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        game.doHit(2);
        counter = counter + 1;
        paneel.repaint();
      }
    });

    paneel.setBackground(Color.black);
    frame.pack();
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null); // viib akna ekraani keskele;
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new Client().ava();
  }

}
