package gui;

import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
@SuppressWarnings({"serial","unused"})
public class FileDestroyer extends JFrame{

	private ArrayList<File> criminals = new ArrayList<>();
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
	private JComboBox<String> list = new JComboBox<>(model);
	private int selectedIndex = -1;
	private JPanel panel = new JPanel();
	private void initUI(){
		JButton deleteSelected = new JButton("Delete selected"),
				deleteAll = new JButton("Delete all");
		
	
	}
	public FileDestroyer(){
		initUI();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->new FileDestroyer());
	}
}
