import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class PersonDM extends AbstractTableModel
{
	ActionCreate aCreate = new ActionCreate();
	ActionRead aRead     = new ActionRead();
	ActionUpdate aUpdate = new ActionUpdate();
	ActionDelete aDelete = new ActionDelete();
	ActionComboBox aBox  = new ActionComboBox();
	ActionBut aOk = new ActionBut();
	ActionButN aNo = new ActionButN();
	
	ArrayList<Person> pp = new ArrayList<Person>();;
	PersonDAO         pd = new PersonDAO_Mock();
	
	Window frame;
	String choice;
	
	private void reload() 
	{
		pp = pd.read();
		fireTableDataChanged(); // перезагружаем(перезаполняем после изменения) таблицу
	}
	
	class ActionComboBox implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox box = (JComboBox)e.getSource();
            String item = (String)box.getSelectedItem();
            switch(item)
            {
            case "Mock" : pd = new PersonDAO_Mock(); break;
            case "SQL"  : pd = new PersonDAO_SQL();  break;
            case "H2"   : pd = new PersonDAO_H2();   break;
            }
		}
	}
	
	class ActionCreate implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			choice = "create";
			frame = new Window();
		}
	}
	
	class ActionRead implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp = pd.read();
			fireTableDataChanged();
		}
	}
	
	class ActionUpdate implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			choice = "update";
			frame = new Window();
		}
	}
	
	class ActionDelete implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			choice = "delete";
			frame = new Window();
		}
	}
	class ActionBut implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(choice)
			{
				case "create" : 
				{
					Person p = new Person(Integer.parseInt(frame.id.getText()), frame.fn.getText(), frame.ln.getText(), Integer.parseInt(frame.age.getText()));
					pd.create(p);
					reload();
				}; break;
				case "update" : 
				{
					Person p = new Person(Integer.parseInt(frame.id.getText()), frame.fn.getText(), frame.ln.getText(), Integer.parseInt(frame.age.getText()));
					pd.update(p);
					reload();
				}; break;
				case "delete" : 
				{
					Person p = new Person(Integer.parseInt(frame.id.getText()),"hssh","fgh",5);
					pd.delete(p);
					reload();
				}; break;
			}
			frame.dispose();
		}
	}
	
	class ActionButN implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			frame.dispose();
		}
	}

	
	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public int getRowCount() 
	{
		return pp.size();
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Person p = pp.get(row);
		Object res = null;
		switch(col)
		{
		case 0 : res = p.id; break;
		case 1 : res = p.fname; break;
		case 2 : res = p.lname; break;
		case 3 : res = p.age; break;
		}
		return res;
	}
@Override
public String getColumnName(int col) 
{
	String[] str = {"ID","FNAME","LNAME","AGE"};
	return str[col];
}
}
