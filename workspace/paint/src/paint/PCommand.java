package paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCommand 
{
	PData data = null;
	
	public PCommand(PData data)
	{
		this.data = data; // принимаем дата и инициализируем поле
	}
	
	ActionWidth aWidth = new ActionWidth();
	ActionColor aColor = new ActionColor();
	ActionType aType = new ActionType();
	
	
	class ActionColor implements ActionListener
	{
		 public void actionPerformed(ActionEvent e) 
	        {
			 String str = e.getActionCommand();
			 switch(str)
			 {
			 case "red" : data.clr = Color.red; break;
			 case "green" : data.clr = Color.green; break;
			 case "blue" : data.clr = Color.blue; break;
			 default : break;
			 }
	        }
	}
	
	class ActionWidth implements ActionListener
	{
		 public void actionPerformed(ActionEvent e) 
	        {
			 String str = e.getActionCommand();
			 switch(str)
			 {
			 case "bt1" : data.width = 1; break;
			 case "bt2" : data.width = 2; break;
			 case "bt4" : data.width = 4; break;
			 default : break;
			 }
	        }
	}
	
	class ActionType implements ActionListener
	{
		 public void actionPerformed(ActionEvent e) 
	        {
			 String str = e.getActionCommand();
			 switch(str)
			 {
			 case "curve" : data.type = "curve"; break;
			 case "line" : data.type = "line"; break;
			 case "rect" : data.type = "rect"; break;
			 case "Rrect" : data.type = "Rrect"; break;
			 case "oval" : data.type = "oval"; break;
			 default : break;
			 }
	        }
	}
}
