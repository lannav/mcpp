package blogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.table.AbstractTableModel;
import DAL.PersonDAO;
import DAL.PersonDAO_CSV;
import DAL.PersonDAO_H2;
import DAL.PersonDAO_JSON;
import DAL.PersonDAO_Mock;
import DAL.PersonDAO_MySQL_Hibernate;
import DAL.PersonDAO_SQL;
import DAL.PersonDAO_XML;
import DAL.PersonDAO_YAML;
import IE.ImplExp;
import View.PPanel;
import View.Window;

public class PersonDM extends AbstractTableModel
{
	public ActionCreate aCreate = new ActionCreate();
	public ActionRead aRead     = new ActionRead();
	public ActionUpdate aUpdate = new ActionUpdate();
	public ActionDelete aDelete = new ActionDelete();
	public ActionComboBox aBox  = new ActionComboBox();
	public ActionBut aOk = new ActionBut();
	public ActionButN aNo = new ActionButN();
	public ActionSL aSL = new ActionSL();
	
	ArrayList<Person> pp = new ArrayList<Person>();;
	PersonDAO         pd = new PersonDAO_MySQL_Hibernate();
	ImplExp ie;
	
	boolean isOk = false;
	boolean isCancel = false;
	
	private void reload() 
	{
		pp = pd.read();
		fireTableDataChanged(); // перезагружаем(перезаполн€ем после изменени€) таблицу
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
            case "XML"  : pd = new PersonDAO_XML();  break;
            case "JSON" : pd = new PersonDAO_JSON(); break;
            case "YAML" : pd = new PersonDAO_YAML(); break;
            case "CSV"  : pd = new PersonDAO_CSV();  break;
            }
		}
	}
	
	class ActionCreate implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PPanel.dm.isOk = false;
			PPanel.dm.isCancel = false;
			Window frame = new Window();
			if(PPanel.dm.isOk == true)
			{
				Person p = new Person(Integer.parseInt(frame.id.getText()), frame.fn.getText(), frame.ln.getText(), Integer.parseInt(frame.age.getText()));
				pd.create(p);
				reload();
				frame.dispose();
			} else if(PPanel.dm.isCancel == true)
				frame.dispose();
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
			PPanel.dm.isOk = false;
			PPanel.dm.isCancel = false;
			Window frame = new Window();
			if(PPanel.dm.isOk == true)
			{
				Person p = new Person(Integer.parseInt(frame.id.getText()), frame.fn.getText(), frame.ln.getText(), Integer.parseInt(frame.age.getText()));
				pd.update(p);
				reload();
				frame.dispose();
			} else if(PPanel.dm.isCancel == true)
				frame.dispose();
		}
	}
	
	class ActionDelete implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PPanel.dm.isOk = false;
			PPanel.dm.isCancel = false;
			final Window frame = new Window();
			if(PPanel.dm.isOk == true)
			{
			Person p = new Person(Integer.parseInt(frame.id.getText()),"hssh","fgh",5);
			pd.delete(p);
			reload();
			frame.dispose();
			} else if(PPanel.dm.isCancel == true)
				frame.dispose();
		}
	}
	class ActionBut implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PPanel.dm.isOk = true;
//			Window.getInstance().setVisible(false);
		}
	}
	
	class ActionButN implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			PPanel.dm.isCancel = true;
			Window.getInstance().setVisible(false);
		}
	}
	
	class ActionSL implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			File file;
			JFileChooser fileopen = new JFileChooser();
			File Xfile = new File("E:\\PersonData");
			fileopen.setCurrentDirectory(Xfile);
            int ret = fileopen.showDialog(null, "¬ыберите файл");                
            if (ret == JFileChooser.APPROVE_OPTION)
            {
            file = fileopen.getSelectedFile();
            IESelect ies = new IESelect();
            ie = ies.getIE(file, pp);
            String choise = arg0.getActionCommand();
            
            switch(choise)
            {
            case "save" : ie.save(); break;
            case "load" : 
			            {
			            	pp = ie.load();
			            	fireTableDataChanged();
			            	pd = new PersonDAO_Mock(pp);
			            } break;
			default : break;
            }
            }	
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
