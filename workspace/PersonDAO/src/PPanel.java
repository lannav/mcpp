import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PPanel extends JPanel 
{
	static JTable tb;
	static PersonDM dm;
	
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
		
		String[] items = { "Mock", "SQL", "H2"};
		JComboBox cb = new JComboBox(items);
		cb.setBounds(530, 30, 120, 30);
		cb.setBackground(Color.red);
		cb.addActionListener(dm.aBox);
		add(cb);
		
		/*id = new JTextField();
		JLabel idl = new JLabel("id");
		idl.setBounds(420, 180, 80, 20);
		id.setBounds(420, 205, 350, 30);
		add(id);
		add(idl);
		
		fname = new JTextField();
		JLabel fnl = new JLabel("fname");
		fnl.setBounds(420, 250, 80, 20);
		fname.setBounds(420, 275, 350, 30);
		add(fname);
		add(fnl);
		
		lname = new JTextField();
		JLabel lnl = new JLabel("lname");
		lnl.setBounds(420, 320, 80, 20);
		lname.setBounds(420, 345, 350, 30);
		add(lname);
		add(lnl);
		
		age = new JTextField();
		JLabel agel = new JLabel("age");
		agel.setBounds(420, 390, 80, 20);
		age.setBounds(420, 415, 350, 30);
		add(age);
		add(agel);*/
	}
}