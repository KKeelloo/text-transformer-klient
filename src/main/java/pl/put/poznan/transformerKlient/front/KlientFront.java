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
}
