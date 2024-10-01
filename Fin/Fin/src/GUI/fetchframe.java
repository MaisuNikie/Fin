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
import javax.swing.plaf.basic.BasicScrollBarUI;

import WebScrape.*;

public class fetchframe extends WebScrape implements ActionListener {
    JFrame fetchFrame = new JFrame();
    //JPanel listPanel;
    JButton returnButton;
    DefaultListModel dlm = new DefaultListModel();
    JList list = new JList(dlm);
    JScrollPane listScroll = new JScrollPane(list);

    fetchframe() {

        ImageIcon fetch = new ImageIcon("D:\\New School\\IA\\CompSci\\Fin\\Fin\\src\\fetch.png");

        returnButton = new JButton();
        //returnButton.setBounds(110, 50, 200, 50);
        returnButton.setPreferredSize(new Dimension(200, 50));
        returnButton.addActionListener(this);
        returnButton.setText("Return");

        returnButton.setFocusable(false);
        //fetchButton.setIcon(fetch);
        returnButton.setHorizontalTextPosition(JButton.CENTER);
        returnButton.setVerticalTextPosition(JButton.BOTTOM);
        returnButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        returnButton.setForeground(new Color(0xFFFFFF));
        returnButton.setBackground(new Color(0xb6b1de));
        returnButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));

        //listPanel = new JPanel();
        //listPanel.setPreferredSize(new Dimension(340, 600));
        
        //list.setFont(new Font("Century Gothic",Font.BOLD,50)); //set font of text
        //listPanel.setForeground(new Color(0xFFFFFF));
        listScroll.setPreferredSize(new Dimension(380, 600));
 
        //webOut();
        WebScrape webout = new WebScrape();
        ArrayList<String> tickersL = webout.gettickersL();
        ArrayList<String> nameL = webout.getnameL();
        ArrayList<String> priceL = webout.getpriceL();

        for (int i = 0; i < tickersL.size(); i++) {
            dlm.addElement(nameL.get(i) + " - " + tickersL.get(i) + " - " + priceL.get(i) + "$");
        }
 
        listScroll.setHorizontalScrollBarPolicy(listScroll.HORIZONTAL_SCROLLBAR_NEVER);
        listScroll.setVerticalScrollBarPolicy(listScroll.VERTICAL_SCROLLBAR_AS_NEEDED);
        listScroll.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));
        //listScroll.setForeground(new Color(0xb6b1de));
        //listScroll.setBackground(new Color(0xb6b1de));

        /*listScroll.setOpaque(false);
        listScroll.getViewport().setBackground(new Color(0xb6b1de));
        listScroll.setBackground(new Color(0xb6b1de)); */

        listScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0x8b90c7);
            }
        });

        // reused code
        fetchFrame.setTitle("Fin Fetch"); //sets title of frame
        fetchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
        //this.setLayout(new GridLayout(3, 1, 0, 0)); //set layout manager
        fetchFrame.setLayout(new FlowLayout());
        fetchFrame.setResizable(false); //prevent frame from being resized
        fetchFrame.setSize(420,720); //sets the x-dimension, and y-dimension of frame
        fetchFrame.setVisible(true); //make frame visible
        fetchFrame.getContentPane().setBackground(new Color(0xb6b1de));
        fetchFrame.add(returnButton);
        fetchFrame.add(listScroll);
        fetchFrame.setIconImage(fetch.getImage());


    }

    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==returnButton) {
			//fetchButton.setEnabled(false);
            fetchFrame.dispose(); 
            mainframe mainFrame = new mainframe();
            //fetchframe fetchFrame = new fetchframe();
		}	
	}
}
