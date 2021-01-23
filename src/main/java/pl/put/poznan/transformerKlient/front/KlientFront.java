package pl.put.poznan.transformerKlient.front;

import pl.put.poznan.transformerKlient.back.KlientBackend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KlientFront {
    private JPanel panelMain;
    private JTextPane txtInput;
    private JTextPane txtOutput;
    private JButton btnReset;
    private JButton btnEnter;
    private JTabbedPane tabbedInput;
    private JTabbedPane tabbedOutput;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;

    public KlientFront() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //form reset
                comboBox1.setSelectedIndex(0);
                comboBox2.setSelectedIndex(0);
                comboBox2.setEnabled(false);
                comboBox3.setSelectedIndex(0);
                comboBox3.setEnabled(false);
                comboBox4.setSelectedIndex(0);
                comboBox4.setEnabled(false);
                comboBox5.setSelectedIndex(0);
                comboBox5.setEnabled(false);
                comboBox6.setSelectedIndex(0);
                comboBox6.setEnabled(false);
                comboBox7.setSelectedIndex(0);
                comboBox7.setEnabled(false);
                comboBox8.setSelectedIndex(0);
                comboBox8.setEnabled(false);
                comboBox9.setSelectedIndex(0);
                comboBox9.setEnabled(false);
            }
        });
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String,String> map = new HashMap<>();
                map.put("Zmiana na małe litery", "lower");
                map.put("Rozwijanie skrótów", "short2str");
                map.put("Zmiana na duże litery", "upper");
                map.put("Pierwsze litery w każdym słowie duże", "capital");
                map.put("Zwijanie do skrótów", "str2short");
                map.put("Zmiana liczb całkowitych na słowa", "up2k");
                map.put("Usuwanie powtarzających się słów", "rep");
                map.put("Zmiana liczb zmiennoprzecinkowych na słowa", "rep");
                map.put("Odwracanie ciągu zaków", "ix");
                String text = txtInput.getText();
                ArrayList<String> transforms = new ArrayList<>();
                if(!comboBox9.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox9.getSelectedItem()));
                }
                if(!comboBox8.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox8.getSelectedItem()));
                }
                if(!comboBox7.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox7.getSelectedItem()));
                }
                if(!comboBox6.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox6.getSelectedItem()));
                }
                if(!comboBox5.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox5.getSelectedItem()));
                }
                if(!comboBox4.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox4.getSelectedItem()));
                }
                if(!comboBox3.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox3.getSelectedItem()));
                }
                if(!comboBox2.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox2.getSelectedItem()));
                }
                if(!comboBox1.getSelectedItem().equals("")){
                    transforms.add(map.get(comboBox1.getSelectedItem()));
                }
                String resp = KlientBackend.request(text, transforms);
                txtOutput.setText(resp);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox2.setEnabled(true);
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox3.setEnabled(true);
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox4.setEnabled(true);
            }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox5.setEnabled(true);
            }
        });
        comboBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox6.setEnabled(true);
            }
        });
        comboBox6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox7.setEnabled(true);
            }
        });
        comboBox7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox8.setEnabled(true);
            }
        });
        comboBox8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox9.setEnabled(true);
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
