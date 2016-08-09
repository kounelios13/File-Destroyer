package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
@SuppressWarnings({"serial","unused"})
public class FileDestroyer extends JFrame{

	private int selectedIndex = -1;
	private JPanel panel = new JPanel();
	private void initUI(){
		
	}
	public FileDestroyer(){
		initUI();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->new FileDestroyer());
	}
}
