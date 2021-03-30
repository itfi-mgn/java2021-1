package lesson4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class JFrameTest extends JFrame {
	public JFrameTest() {
		this.setTitle("test title");
		this.setSize(100, 100);
		System.err.println("size="+this.getSize());
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel	label = new JLabel("my label");		
		JLabel	label2 = new JLabel("<LABEL2>");
		
		label.setPreferredSize(new Dimension(200,200));
		
		getContentPane().add(label);
		getContentPane().add(label2);
		
		label2.setBorder(new LineBorder(Color.RED,10));
		
		JButton	butt = new JButton("<html><body><font color=red>URA!!!</body></html>");
		
		butt.addActionListener((e)->{System.err.println("button pressed (c) Captain Obvious");});
	
		butt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				butt.setBorder(new LineBorder(Color.GREEN));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				butt.setBorder(new LineBorder(Color.RED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		getContentPane().add(butt);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrameTest	test = new JFrameTest();
		
		test.setVisible(true);
		System.err.println("size="+test.getSize());
	}

}
