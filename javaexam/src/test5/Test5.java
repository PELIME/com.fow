package test5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Test5 extends JFrame {
    public Test5()
    {
        //Dimension screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int height=size.height;
        int width=size.width;
        this.setBounds(width/4,height/4,width/2,height/2);
        JMenuBar jMenuBar=new JMenuBar();
        JMenu jMenu=new JMenu("File");
        JMenuItem jMenuItem1=new JMenuItem("Open");
        JMenuItem jMenuItem2=new JMenuItem("Close");
        jMenuItem1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jMenuItem1)
                    JOptionPane.showMessageDialog(jMenuItem1,"Open菜单被点击");
            }
        });
        jMenuItem2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jMenuItem2)
                    dispose();
            }
        });
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);
        this.setVisible(true);
        this.validate();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Test5 test5=new Test5();
    }

}
