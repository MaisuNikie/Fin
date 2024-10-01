package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainframe extends JFrame implements ActionListener {
    JLabel title;
    JButton fetchButton;
    JButton lookButton;

    mainframe() {

        ImageIcon fetch = new ImageIcon("D:\\New School\\IA\\CompSci\\Fin\\Fin\\src\\fetch.png");

        title = new JLabel();
        title.setBounds(0, 210, 420, 50);
        //title.setPreferredSize(new Dimension(100, 50));
        title.setText("Fin");
        //title.setIcon(fetch);
        title.setFont(new Font("Century Gothic",Font.BOLD,50)); //set font of text
        title.setForeground(new Color(0xFFFFFF));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);

        fetchButton = new JButton();
        fetchButton.setBounds(110, 300, 200, 50);
        //fetchButton.setPreferredSize(new Dimension(100, 50));
        fetchButton.addActionListener(this);
        fetchButton.setText("Fetch Data");

        fetchButton.setFocusable(false);
        //fetchButton.setIcon(fetch);
        fetchButton.setHorizontalTextPosition(JButton.CENTER);
        fetchButton.setVerticalTextPosition(JButton.BOTTOM);
        fetchButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        fetchButton.setIconTextGap(-15);
        fetchButton.setForeground(new Color(0xFFFFFF));
        fetchButton.setBackground(new Color(0xb6b1de));
        fetchButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));

        lookButton = new JButton();
        lookButton.setBounds(110, 375, 200, 50);

        lookButton.addActionListener(this);
        lookButton.setText("Find with Ticker");

        lookButton.setFocusable(false);
        //fetchButton.setIcon(fetch);
        lookButton.setHorizontalTextPosition(JButton.CENTER);
        lookButton.setVerticalTextPosition(JButton.BOTTOM);
        lookButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lookButton.setIconTextGap(-15);
        lookButton.setForeground(new Color(0xFFFFFF));
        lookButton.setBackground(new Color(0xb6b1de));
        lookButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x8b90c7)));

        this.setTitle("Fin"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
        //this.setLayout(new GridLayout(3, 1, 0, 0)); //set layout manager
        this.setLayout(null);
        this.setResizable(false); //prevent frame from being resized
        this.setSize(420,720); //sets the x-dimension, and y-dimension of frame
        this.setVisible(true); //make frame visible
        this.getContentPane().setBackground(new Color(0xb6b1de));
        this.add(title);  //adds label to frame
        this.add(fetchButton); //adds button to frame
        this.add(lookButton);
        this.setIconImage(fetch.getImage());

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fetchButton) {
			//fetchButton.setEnabled(false);
            this.dispose(); 
            fetchframe fetchFrame = new fetchframe();
		}	

        if(e.getSource()==lookButton) {
			//fetchButton.setEnabled(false);
            this.dispose(); 
            lookframe lookFrame = new lookframe();
		}
	}

    
}
