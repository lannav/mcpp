package View;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JDialog
	{
		public static Window instance = null;
	
		public JTextField id;
		public JTextField fn;
		public JTextField ln;
		public JTextField age;
		
		public boolean isOk = false;
		public boolean isCancel = false;
		
		public static Window getInstance()
		{
			if(instance == null)
				instance = new Window();
			
			return instance;
		}
		
		public Window()
		{
			instance = this;
			setTitle("Set ID FNAME LNAME AGE");
			setBounds(300,300,400,400);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(null);
			
			JLabel lbId = new JLabel("ID");
			lbId.setBounds(20, 20, 100, 20);
			add(lbId);
			
			String idStr;
			String fnameStr;
			String lnameStr;
			String ageStr;
			
			if(PPanel.tb.getSelectedRow() == -1)
			{
				idStr = "";
				fnameStr = "";
				lnameStr = "";
				ageStr = "";
			}
			else
			{
				idStr = PPanel.tb.getModel().getValueAt(PPanel.tb.getSelectedRow(), 0).toString();
				fnameStr = (String) PPanel.tb.getModel().getValueAt(PPanel.tb.getSelectedRow(), 1);
				lnameStr = (String) PPanel.tb.getModel().getValueAt(PPanel.tb.getSelectedRow(), 2);
				ageStr = PPanel.tb.getModel().getValueAt(PPanel.tb.getSelectedRow(), 3).toString();
			}
			
			id = new JTextField(idStr);
			id.setBounds(20, 50, 200, 30);
			add(id);
			
			JLabel lbFname = new JLabel("FNAME");
			lbFname.setBounds(20, 90, 100, 20);
			add(lbFname);
			
			fn = new JTextField(fnameStr);
			fn.setBounds(20, 120, 200, 30);
			add(fn);
			
			JLabel lbLname = new JLabel("LNAME");
			lbLname.setBounds(20, 160, 100, 20);
			add(lbLname);
			
			ln = new JTextField(lnameStr);
			ln.setBounds(20, 190, 200, 30);
			add(ln);
			
			JLabel lbAge = new JLabel("AGE");
			lbAge.setBounds(20, 230, 100, 20);
			add(lbAge);
			
			age = new JTextField(ageStr);
			age.setBounds(20, 260, 200, 30);
			add(age);
			
			JButton ok = new JButton("OK");
			ok.setBounds(50, 300, 120, 20);
			ok.addActionListener(PPanel.dm.aOk);
			add(ok);
			
			JButton can = new JButton("CANCEL");
			can.setBounds(180, 300, 120, 20);
			can.addActionListener(PPanel.dm.aNo);
			add(can);
			setModal(true);
			setVisible(true);
		}
	}