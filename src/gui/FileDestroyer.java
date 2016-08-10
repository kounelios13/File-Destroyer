package gui;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utils.FileDrop;
@SuppressWarnings({"serial"})
public class FileDestroyer extends JFrame{

	private ArrayList<File> criminals = new ArrayList<>();
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
	private JComboBox<String> list = new JComboBox<>(model);
	private int selectedIndex = -1;
	private JPanel panel = new JPanel();
	private void initUI(){
		list.setVisible(false);
		JButton deleteSelected = new JButton("Delete selected"),
				deleteAll = new JButton("Delete all");
		panel.add(list);
		panel.add(deleteSelected);
		panel.add(deleteAll);
		deleteSelected.addActionListener((e)->{
			if(selectedIndex==-1)
				return;
			boolean death = criminals.get(selectedIndex).delete();
			if(death)
				JOptionPane.showMessageDialog(null,"File deleted");
			else
				JOptionPane.showMessageDialog(null, "File not deleted");
			if(death){
				model.removeElementAt(selectedIndex);
				criminals.remove(selectedIndex);
			}
		});
		list.addActionListener((e)->selectedIndex = list.getSelectedIndex());
		deleteAll.addActionListener((e)->{
			/*for(File f:criminals)
				f.delete();*/
				if(criminals.isEmpty())
					return;
			criminals.stream().forEach((f)->deleteFiles(f));	
		});
		setContentPane(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	public void deleteFiles(File e){
		if(e==null)
			return;
		if(e.isDirectory())
			for(File inner:e.listFiles())
				deleteFiles(inner);
		else
			e.delete();
	}
	public FileDestroyer(){
		initUI();
		new FileDrop(this,(e)->{
			/*for(File f:e){
				criminals.add(f);
				model.addElement(f.getName()+(f.isDirectory()?" (Folder)":""));
			}*/
			Stream.of(e).forEach((f)->{
				criminals.add(f);
				model.addElement(f.getName()+(f.isDirectory()?" (Folder)":""));
			});
			list.setVisible(!criminals.isEmpty());
		});
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->new FileDestroyer());
	}
}
