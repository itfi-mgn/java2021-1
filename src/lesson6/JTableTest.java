package lesson6;

import java.awt.Color;
import java.awt.Component;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class JTableTest extends JFrame {
	public JTableTest() {
//		final File[]	f = new File("c:/sqlDeveloper").listFiles();
		
		TableModel tm = new DefaultTableModel() {
//			String[][]	content = new String[][] {
//							new String[] {"val 1.1","val 1.2","val 1.3"},
//							new String[] {"val 2.1","val 2.2","val 2.3"},
//							new String[] {"val 3.1","val 3.2","val 3.3"},
//						};
			
			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//				content[rowIndex][columnIndex] = (String)aValue;
			}
			
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return true;
			}
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch (columnIndex) {
					case 0 : return true;
					case 1 : return MyEnum.Enum1;
					case 2 : return "String dsfjglkjdlkgdlfkgj";
					default : return null;
				}
//				return content[rowIndex][columnIndex];
			}
			
			@Override
			public int getRowCount() {
				return 2;
				//content == null ? 0 : content.length;
			}
			
			@Override
			public String getColumnName(int columnIndex) {
				switch (columnIndex) {
					case 0 : return "first";
					case 1 : return "second";
					case 2 : return "third";
					default : return "?????";
				}
			}
			
			@Override
			public int getColumnCount() {
				return 3;//content[0].length;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
					case 0 : return Boolean.class;
					case 1 : return MyEnum.class;
					case 2 : return String.class;
					default : return Object.class;
				}
				
			}
		};
		JTable	table = new JTable(tm);
		JScrollPane pane = new JScrollPane(table);
		
		table.setDefaultRenderer(Boolean.class, new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				// TODO Auto-generated method stub
				final JLabel	label = new JLabel(value.toString());
				
				if (isSelected) {
					label.setForeground(Color.RED);
				}
				if (hasFocus) {
					label.setBorder(new LineBorder(Color.GREEN));
				}
				else {
					label.setBorder(new LineBorder(Color.MAGENTA));
				}
				
				return label;
			}
		});
		
		getContentPane().add(pane);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JTableTest tt = new JTableTest();
		
		tt.setVisible(true);
	}

}
