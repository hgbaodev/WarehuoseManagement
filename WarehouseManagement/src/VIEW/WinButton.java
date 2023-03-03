package VIEW;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sswing.PanelBackground;

public class WinButton extends JPanel{
    private Button cmdClose;
    private Button cmdMi;
    private Button cmdRe;

    public WinButton() {
        init();
    }
    
    public void init(){
        cmdClose = new Button();
        cmdMi = new Button();
        cmdRe = new Button();

        cmdClose.setBackground(new java.awt.Color(240, 61, 61));

        cmdMi.setBackground(new java.awt.Color(227, 226, 68));

        cmdRe.setBackground(new java.awt.Color(67, 199, 51));
        
        setLayout(new FlowLayout(1,5,5));
        this.setOpaque(false);
        this.add(cmdMi);
        this.add(cmdRe);
        this.add(cmdClose);
    }
    
    public void initEvent(JFrame jf, PanelBackground jp){
        cmdClose.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cmdMi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setState(JFrame.ICONIFIED);
            }
        });
        cmdRe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jf.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    jp.setRound(20);
                    jf.setExtendedState(JFrame.NORMAL);
                } else {
                    jp.setRound(0);
                    jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        });
    }
}
