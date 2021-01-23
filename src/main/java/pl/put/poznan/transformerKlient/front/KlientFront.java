package pl.put.poznan.transformerKlient.front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlientFront {
    private JPanel panelMain;
    private JTextPane txtInput;
    private JTextPane txtOutput;
    private JButton btnReset;
    private JButton btnEnter;
    private JCheckBox pierwszeLiteryWKażdymCheckBox;
    private JCheckBox zmianaNaDużeLiteryCheckBox;
    private JCheckBox zwijanieDoSkrótówCheckBox;
    private JCheckBox zmianaLiczbZmiennoprzecinkowychNaCheckBox;
    private JCheckBox odwracanieCiąguZakówCheckBox;
    private JCheckBox zmianaNaMałeLiteryCheckBox;
    private JCheckBox rozwijanieSkrótówCheckBox;
    private JCheckBox zmianaLiczbCałkowitychNaCheckBox;
    private JCheckBox usuwaniePowtarzającychSięSłówCheckBox;
    private JTabbedPane tabbedInput;
    private JTabbedPane tabbedOutput;

    public KlientFront() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //form reset
            }
        });
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transform text
            }
        });
    }


    public static void main(String[] args){
        JFrame frame = new JFrame("Text-Transformer");
        frame.setContentPane(new KlientFront().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
