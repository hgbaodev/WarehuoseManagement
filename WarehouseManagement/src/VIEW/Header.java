/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import sswing.PanelBackground;

/**
 *
 * @author robot
 */
public class Header extends JPanel{
    private WinButton winButton;
    private int x;
    private int y;
    
    public Header(){
        init();
        this.setOpaque(false);
    }
    
    
    public void init(){
        winButton =  new WinButton();
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(winButton);
    }
    
    public void initEvent(JFrame fram, PanelBackground pb){
        winButton.initEvent(fram, pb);
    }
    
    public void initMoving(JFrame fram) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    x = me.getX();
                    y = me.getY();
                }
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
                }
            }
        });
    }
}
