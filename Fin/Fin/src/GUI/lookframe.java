package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;

import WebScrape.*;

public class lookframe extends WebScrape implements ActionListener{

    //WebScrape webscrape = new WebScrape();
    //String userinput = webscrape.userinput;
    String userinput;

    JFrame lookFrame;
    JButton returnButton;
    JButton submitButton;
    JTextField tickerField;
    JPanel outputPanel;
    JLabel returned;

    lookframe() {

        ImageIcon fetch = new ImageIcon("D:\\New School\\IA\\CompSci\\Fin\\Fin\\src\\fetch.png");

        returnButton = new JButton();
        returnButton.setPreferredSize(new Dimension(200, 50));
        returnButton.addActionListener(this);
        returnButton.setText("Return");

        returnButton.setFocusable(false);
        returnButton.setHorizontalTextPosition(JButton.CENTER);
        returnButton.setVerticalTextPosition(JButton.BOTTOM);
        returnButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        returnButton.setForeground(new Color(0xFFFFFF));
        returnButton.setBackground(new Color(0xb6b1de));
        returnButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));

        submitButton = new JButton();
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.addActionListener(this);
        submitButton.setText("Submit");

        submitButton.setFocusable(false);
        submitButton.setHorizontalTextPosition(JButton.CENTER);
        submitButton.setVerticalTextPosition(JButton.BOTTOM);
        submitButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        submitButton.setForeground(new Color(0xFFFFFF));
        submitButton.setBackground(new Color(0xb6b1de));
        submitButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));

        tickerField = new JTextField();
        tickerField.setPreferredSize(new Dimension(200, 50));
        tickerField.setFont(new Font("Consolas", Font.PLAIN, 14));
        tickerField.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));
        tickerField.setForeground(new Color(0x000000));
        tickerField.setBackground(new Color(0xe6e4f7));

        outputPanel = new JPanel();
        outputPanel.setPreferredSize(new Dimension(320, 270));
        outputPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));

        //outputPanel.add(returned);

        returned = new JLabel();
        returned.setPreferredSize(new Dimension(320, 50));
        returned.setFont(new Font("Consolas", Font.PLAIN, 14));
        returned.setVisible(true);
        returned.setOpaque(true);
        returned.setText("");
        returned.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));





        lookFrame = new JFrame("Fin - Look Up Ticker");
        lookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lookFrame.setSize(420, 720);
        lookFrame.setLayout(new FlowLayout( FlowLayout.CENTER, 5, 50));
        lookFrame.getContentPane().setBackground(new Color(0xb6b1de));
        lookFrame.setVisible(true);

        lookFrame.add(returnButton);
        lookFrame.add(tickerField);
        lookFrame.add(submitButton);
        //lookFrame.add(outputPanel);
        lookFrame.add(returned);
        lookFrame.setIconImage(fetch.getImage());
    }





    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==returnButton) {
			//fetchButton.setEnabled(false);
            lookFrame.dispose(); 
            mainframe mainFrame = new mainframe();
            //fetchframe fetchFrame = new fetchframe();
		}	

        if(e.getSource()==submitButton) {
			userinput = tickerField.getText();
            //System.out.println(userinput);

            webOut();
            getfrmTickersN(userinput);
            getfrmTickersP(userinput);
            getfrmTickersI(userinput);

            String namefromticker = getfrmTickersN(userinput);
            Double pricefromticker = getfrmTickersP(userinput);
            int indexfromticker = getfrmTickersI(userinput);

            returned.setOpaque(true);
            //returned.setText(" " + namefromticker + " - ticker: " + userinput + " - rank: " + (indexfromticker) + " - price: " + pricefromticker + "$");
            returned.setText(" " + namefromticker + " - " + userinput + " - " + (indexfromticker) + " - " + pricefromticker + "$");
		}
	}
}
