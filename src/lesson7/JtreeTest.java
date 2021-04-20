package lesson7;

import java.awt.Component;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class JtreeTest extends JFrame {
	public JtreeTest() {
		DefaultMutableTreeNode	dmtn = new DefaultMutableTreeNode(new String[] {"aa"},true);
		DefaultMutableTreeNode	child1 = new DefaultMutableTreeNode("item 1", true);
		DefaultMutableTreeNode	child2 = new DefaultMutableTreeNode("item 2", true);
		DefaultMutableTreeNode	child3 = new DefaultMutableTreeNode("item 3", true);
		
		dmtn.add(child1);
		dmtn.add(child2);
		dmtn.add(child3);
		
		JTree		tree = new JTree(dmtn);
		JScrollPane	pane = new JScrollPane(tree);
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Change new: "+e.getNewLeadSelectionPath());
				System.err.println("Change old: "+e.getOldLeadSelectionPath());
				TreePath	tp = e.getNewLeadSelectionPath();
				System.err.println("Path: "+Arrays.toString(tp.getPath()));
				System.err.println("Last Path: "+tp.getLastPathComponent());
			}
		});
		tree.setRootVisible(false);
		
		tree.setCellRenderer(new TreeCellRenderer() {
			@Override
			public Component getTreeCellRendererComponent(JTree tree, 
					Object value, boolean selected, boolean expanded,
					boolean leaf, int row, boolean hasFocus) {
				// TODO Auto-generated method stub
				return new JButton(value.toString());
			}
		});
		
		getContentPane().add(pane);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JtreeTest	tt = new JtreeTest();
		
		tt.setVisible(true);
	}

}
