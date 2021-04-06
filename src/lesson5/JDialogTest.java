package lesson5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JDialogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanel		panel = new JPanel();
		JLabel		label = new JLabel("North");
		DecimalFormat	df = new DecimalFormat("#########");
		JTextField	text = new JFormattedTextField(df);
		JButton		press = new JButton("Press me");
		
		press.setToolTipText("<html><body><font color=red>Press me PLEASE!!!!!!!</font></body></html>");

		text.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				label.setText("Type PLEANSE!!!!!!");
			}
		});
		
		
		panel.setLayout(new BorderLayout());
		panel.add(label,BorderLayout.NORTH);
		panel.add(text,BorderLayout.CENTER);
		panel.add(press,BorderLayout.SOUTH);
		panel.setPreferredSize(new Dimension(200,200));

		text.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				if (!text.getText().isEmpty()) {
					return true;
				}
				else {
					label.setText("Type anything in the text field!!!!");
					return false;
				}
			}
		});
		
		JOptionPane.showMessageDialog(null, panel, "my title"
				, JOptionPane.ERROR_MESSAGE);

		System.err.println("Text: "+text.getText());
		
//		final JDialog		dlg = new JDialog();
//		
//		dlg.getContentPane().add(panel);
//		
//		press.addActionListener((e)->{
//			dlg.setVisible(false);
//			dlg.dispose();
//		});
//		dlg.setVisible(true);
		
	}

}
