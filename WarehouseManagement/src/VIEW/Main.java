/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author robot
 */
public class Main extends JFrame implements MouseListener{
    private Header header;
    private Menu menu;
    private JPanel jpanel;
    private PanelBackground pn = new PanelBackground();
    
    public Main(){
        init();
        header.initMoving(this);
        header.initEvent(this, pn);
        this.setVisible(true);
        
    }

    public void init() {
        header = new Header();
        menu = new Menu();
        jpanel = new JPanel();
        this.setUndecorated(true);
        this.setSize(1000,600);
        jpanel.setPreferredSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jpanel.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(0, 50));
        menu.setPreferredSize(new Dimension(240,0));
        jpanel.add(header, BorderLayout.NORTH);
        jpanel.add(menu,BorderLayout.WEST);
        jpanel.setBackground(Color.WHITE);
        jpanel.setForeground(Color.WHITE);
        this.add(jpanel);
    }
    
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Main();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
