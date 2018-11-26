import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TempToCKF 
{
	public TempToCKF()
	{
		String res = "";
		String str = JOptionPane.showInputDialog("input temperature(C,K,F)");
		boolean found = Pattern.matches("\\d+[CKF]", str);

		while(!found)
		{
			str = JOptionPane.showInputDialog("error, input temperature(C,K,F)");
			found = Pattern.matches("\\d+[CKF]", str);
		}
		
		switch(str.substring(str.length() - 1))
		{
			case "C": 
			{
				double temp = Double.parseDouble(str.substring(0,str.length() - 1));
				double tempK = temp + 273.15;
				double tempF = temp * 9 / 5 + 32;
				res = "{\"K\":" + (int)tempK + ",\"F\":" + (int)tempF + "}";
			} break;
			case "K": 
			{
				double temp = Double.parseDouble(str.substring(0,str.length() - 1));
				double tempC = temp - 273.15;
				double tempF = tempC * 9 / 5 + 32;
				res = "{\"C\":" + (int)tempC+ ",\"F\":" + (int)tempF + "}";
			} break;
			case "F": 
			{
				double temp = Double.parseDouble(str.substring(0,str.length() - 1));
				double tempC = (temp - 32) * 5 / 9;
				double tempK = tempC + 273.15;
				res = "{\"K\":" + (int)tempK + ",\"C\":" + (int)tempC + "}";
			} break;
		}
		JOptionPane.showMessageDialog(null,res);
	}	
}
