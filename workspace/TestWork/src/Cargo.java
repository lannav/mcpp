import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/*��� ������ ���������� ���� ����������� ���������� ��������. ���� ������� ����� ������� ��������� �� ��� ����� 
  ������ �����: ����������� n-1 ���� � ��������� � �� ��������� b, ��� n - ���������� ���� ������� ����� �����������
  ������ �����: ����� ������ ����� ��� �������� ����� ������ ����� �� ��������� �, ���������� ��(�����) �� ��������� �, 
  � ��� ��������� ����� ������� �� ����� b 
  ������ �����: ���������� ����� � ��������� b �� �.
  �������� �������� � �� ���������� ����� 8 ����*/



public class Cargo 
{
	public Cargo ()
	{
		String str = JOptionPane.showInputDialog("input number of plates");;
		boolean found = Pattern.matches("\\d+", str);

		while(!found)
		{
			str = JOptionPane.showInputDialog("error, input an integer");
			found = Pattern.matches("\\d+", str);
		}
		
		int slab = Integer.parseInt(str);
		String result = "#1 slot_a -> slot_c\n";
		
		for(int i = 2; i <= slab; i++)
		{
			result = transACAB(result) + "#" + i + " slot_a -> slot_c\n" + transABtoBC(transACAB(result));
		}
		
		JOptionPane.showMessageDialog(null,result);
	}
	
	private String transACAB(String str)
	{
		str = str.replaceAll("c", "x");
		str = str.replaceAll("b", "c");
		str = str.replaceAll("x", "b");

		return str;
	}
	
	private String transABtoBC(String str)
	{
		str = str.replaceAll("a", "x");
		str = str.replaceAll("b", "y");
		str = str.replaceAll("c", "a");
		str = str.replaceAll("x", "b");
		str = str.replaceAll("y", "c");

		return str;
	}
}
