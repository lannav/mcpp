import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*по задания нужно вычислить шаг на котором будет наивысший шанс на удачный выстрел такой шас предоставится на последнем шаге
  если игрок ходит ходит первым или на предпоследнем если игрок ходит вторым*/

public class Tournament 
{
	public Tournament()
	{
		String you = JOptionPane.showInputDialog("input you chance");
		boolean found1 = Pattern.matches("0\\.\\d", you);
		while(!found1)
		{
			you = JOptionPane.showInputDialog("error, input you chance (e.g. 0.2)");
			found1 = Pattern.matches("0\\.\\d", you);
		}
		
		String rival = JOptionPane.showInputDialog("input rival chance");
		boolean found2 = Pattern.matches("0\\.\\d", rival);
		while(!found2)
		{
			rival = JOptionPane.showInputDialog("error, input rival chance (e.g. 0.2)");
			found2 = Pattern.matches("0\\.\\d", rival);
		}
		
		String firstStep = JOptionPane.showInputDialog("who walks first (you - 1, rival - 2)");
		boolean found3 = Pattern.matches("[1-2]", firstStep);
		while(!found3)
		{
			firstStep = JOptionPane.showInputDialog("who walks first (you - 1, rival - 2),error input an integer");
			found3 = Pattern.matches("[1-2]", firstStep);
		}
		
		int fs = Integer.parseInt(firstStep);
		
		if(fs == 1)
			JOptionPane.showMessageDialog(null,"the optimal step for a shot "+10);
		if(fs == 2)
			JOptionPane.showMessageDialog(null,"the optimal step for a shot "+9);
			
	}
}
