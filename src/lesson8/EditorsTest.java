package lesson8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class EditorsTest {
	private static SimpleAttributeSet	bold = new SimpleAttributeSet();
	private static SimpleAttributeSet	normal = new SimpleAttributeSet();

	static {
		StyleConstants.setBold(bold, true);
		StyleConstants.setForeground(bold, Color.RED);
		
		StyleConstants.setBold(normal, true);
		StyleConstants.setForeground(normal, Color.GREEN);
	}
	
	public static void main(String[] args) {
		final JTextField		tf = new JTextField();
		final JTextPane			tp = new JTextPane();
		final JComboBox<String>	combo = new JComboBox<String>(new String[] {"item1","item2","item3"});
		final JPanel			panel = new JPanel(new BorderLayout());

		tf.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				return ((JTextComponent)input).getText().length() > 0;
			}
		});
		
		tp.setPreferredSize(new Dimension(250, 145));
		tp.setBorder(new EtchedBorder());
		tp.getDocument().addDocumentListener(new DocumentListener() {
			volatile boolean	inProcess = false;
			
			@Override public void removeUpdate(DocumentEvent e) {call();}			
			@Override public void insertUpdate(DocumentEvent e) {call();}
			@Override public void changedUpdate(DocumentEvent e) {call();}
			
			private void call() {
				if (!inProcess) {
					inProcess = true;
					
					SwingUtilities.invokeLater(()->{
						try {
							redraw(tp, (StyledDocument)tp.getDocument());
						} finally {
							inProcess = false;
						}
					});
				}
			}
		});
		
		final InputMap	map = new InputMap();
		
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, KeyEvent.CTRL_DOWN_MASK), "clean");
		panel.setInputMap(JPanel.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, map);
		panel.getActionMap().put("clean", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("");
				tp.setText("");
			}
		});
		
		panel.add(tf,BorderLayout.NORTH);
		panel.add(tp,BorderLayout.CENTER);
		panel.add(combo,BorderLayout.SOUTH);
		JOptionPane.showMessageDialog(null, panel);
	}

	private static void redraw(final JTextPane tp, final StyledDocument doc) {
		final char[]	text = tp.getText().replace("\r","").toCharArray();
		
		for (int index = 0; index < text.length; index++) {
			if (text[index] >= '0' && text[index] <= '9') {
				doc.setCharacterAttributes(index, 1, bold, true);
			}
			else {
				doc.setCharacterAttributes(index, 1, normal, true);
			}
		}
	}
}
