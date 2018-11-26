package View;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import blogic.PersonDM;

public class PPanel extends JPanel 
{
	public static JTable tb;
	public static PersonDM dm;
	
	public PPanel()
	{
		setLayout(null);
		setBounds(10, 10, 800, 480);
		
		dm = new PersonDM();
		tb = new JTable(dm); //принимает обьектную модель данных
		JScrollPane sp = new JScrollPane(tb);
		
		sp.setBounds(10, 10, 400, 400);
		add(sp);
		
		JButton create = new JButton("create");
		create.setBounds(460, 150, 120, 20);
		create.setBackground(Color.cyan);
		create.addActionListener(dm.aCreate);
		add(create);
		
		JButton read = new JButton("read");
		read.setBounds(460, 180, 120, 20);
		read.setBackground(Color.cyan);
		read.addActionListener(dm.aRead);
		add(read);
		
		JButton update = new JButton("update");
		update.setBounds(600, 150, 120, 20);
		update.setBackground(Color.cyan);
		update.addActionListener(dm.aUpdate);
		add(update);
		
		JButton delete = new JButton("delete");
		delete.setBounds(600, 180, 120, 20);
		delete.setBackground(Color.cyan);
		delete.addActionListener(dm.aDelete);
		add(delete);
		
		String[] items = { "Mock", "SQL", "H2", "XML", "JSON", "YAML", "CSV"};
		JComboBox cb = new JComboBox(items);
		cb.setBounds(530, 30, 120, 30);
		cb.setBackground(Color.red);
		cb.addActionListener(dm.aBox);
		add(cb);
		
		JButton save = new JButton("SAVE");
		JButton load = new JButton("LOAD");
		save.addActionListener(dm.aSL);
		save.setActionCommand("save");
		load.addActionListener(dm.aSL);
		load.setActionCommand("load");
		save.setBounds(460, 250, 120, 20);
		load.setBounds(600, 250, 120, 20);
		save.setBackground(Color.LIGHT_GRAY);
		load.setBackground(Color.LIGHT_GRAY);
		add(save);
		add(load);
	}
}