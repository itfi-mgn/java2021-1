package lesson7;

import java.awt.Component;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class JtreeTest extends JFrame {
	public JtreeTest() {
//		DefaultMutableTreeNode	dmtn = new DefaultMutableTreeNode(new String[] {"aa"},true);
//		DefaultMutableTreeNode	child1 = new DefaultMutableTreeNode("item 1", true);
//		DefaultMutableTreeNode	child2 = new DefaultMutableTreeNode("item 2", true);
//		DefaultMutableTreeNode	child3 = new DefaultMutableTreeNode("item 3", true);
//		
//		dmtn.add(child1);
//		dmtn.add(child2);
//		dmtn.add(child3);
		Timer		t = new Timer();
		
		TimerTask	tt = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// refresh right part on the screen
			}
		};
		
		t.schedule(tt, 500);
		tt.cancel();
		
		JTree		tree = new JTree(fill(new File("c:/Qt")));
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
		 tree.setShowsRootHandles(true);
		    tree.addTreeWillExpandListener(new TreeWillExpandListener() {
		      @Override
		      public void treeWillExpand(TreeExpansionEvent event)
		          throws ExpandVetoException {
		        TreePath path = event.getPath();
		        if (path.getLastPathComponent() instanceof MyTreeNode) {
		          MyTreeNode node = (MyTreeNode) path.getLastPathComponent();
		          node.loadChildren((DefaultTreeModel)tree.getModel());
		        }
		      }
		      @Override
		      public void treeWillCollapse(TreeExpansionEvent event)
		          throws ExpandVetoException {

		      }
		    });	
//		tree.setRootVisible(false);
		
//		tree.setCellRenderer(new TreeCellRenderer() {
//			@Override
//			public Component getTreeCellRendererComponent(JTree tree, 
//					Object value, boolean selected, boolean expanded,
//					boolean leaf, int row, boolean hasFocus) {
//				// TODO Auto-generated method stub
//				return new JButton(value.toString());
//			}
//		});
		getContentPane().add(pane);
		
	}
	
	private static DefaultMutableTreeNode fill(final File dir) {
		final DefaultMutableTreeNode result = new MyTreeNode(dir);
		
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JtreeTest	tt = new JtreeTest();
		
		tt.setVisible(true);
	}

}


class MyTreeNode extends DefaultMutableTreeNode {
	  boolean loaded = false;

	  public MyTreeNode(File f) {
	    setAllowsChildren(true);
	    setUserObject(f);
	  }

	  @Override
	  public boolean isLeaf() {
	    return false;
	  }

	  public void loadChildren(final DefaultTreeModel model) {
		  System.err.println("Loading...");
		  if (((File)getUserObject()).isDirectory()) {
			  for (File item : ((File)getUserObject()).listFiles()) {
				  add(new MyTreeNode(item));
			  }
		  }
		  model.nodesWereInserted(this,new int[] {0,1});
	  }
	}
