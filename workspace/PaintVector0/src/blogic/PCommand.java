package blogic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import Panels.PContextMenu;
import Panels.PDraw;
import Panels.PFrame;
import Panels.PMenu;
import Panels.PPanel;
import Panels.PToolBar;
import Shapes.PCurve;
import Shapes.PLine;
import Shapes.POval;
import Shapes.PRect;
import Shapes.PRoundRect;
import Shapes.PShape;

public class PCommand 
{
	public PCommand(PFrame frame, PPanel ppnl)
	{
		this.frame = frame;
		this.ppnl = ppnl;
	}
	PPanel ppnl;
	PFrame frame;
	PData data = PData.getInstance();
	public PCommand cmd = this;

	public ActionWidth aWidth = new ActionWidth();
	public ActionColor aColor = new ActionColor();
	public ActionType aType = new ActionType();
	public ActionLoad aLoad = new ActionLoad();
	public ActionSave aSave = new ActionSave();
	public PopupClass ppC = new PopupClass();
	public ActionCB aCheck = new ActionCB();
	public ActionAdd aAdd = new ActionAdd();
	
	class ActionAdd implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if(arg0.getActionCommand() == "del")
			{
				if(ppnl.tabbedPane.getSelectedIndex() == -1) return;
				ppnl.alpd.remove(ppnl.tabbedPane.getSelectedComponent());
				ppnl.tabbedPane.removeTabAt(ppnl.tabbedPane.getSelectedIndex());
			}
			
			if(arg0.getActionCommand() == "add")
			{
				PDraw pdr = new PDraw(ppnl);
				if(ppnl.pcb.context.isSelected())
				{
				pdr.addMouseListener(ppC);
				pdr.validate();
				}
				ppnl.alpd.add(pdr);
				ppnl.tabbedPane.addTab("tab", pdr);
			}
		}
		
	}
	
	class ActionCB implements ItemListener
	{
		PToolBar pt = new PToolBar(cmd);
		
		@Override
		public void itemStateChanged(ItemEvent arg0) 
		{
			if(arg0.getItemSelectable().toString().endsWith("tool bar]"))
			if(ppnl.pcb.toolB.isSelected())
			{
				frame.add(pt.tb);
				frame.validate();
				frame.repaint();
			}else
			{
				frame.remove(pt.tb);
				frame.validate();
				frame.repaint();
			}
			
			if(arg0.getItemSelectable().toString().endsWith("context menu]"))
			if(ppnl.pcb.context.isSelected() == false)
			{
				for(int i = 0; i < ppnl.alpd.size(); i++)
				{
					ppnl.alpd.get(i).removeMouseListener(ppC);
					ppnl.alpd.get(i).validate();
				}
			}else
			{
				for(int i = 0; i < ppnl.alpd.size(); i++)
				{
					ppnl.alpd.get(i).addMouseListener(ppC);
					ppnl.alpd.get(i).validate();
				}
			}
			
			if(arg0.getItemSelectable().toString().endsWith("menu]"))
			if(ppnl.pcb.menu.isSelected())
			{
				frame.setJMenuBar(new PMenu(cmd).mBar);
				frame.validate();
			}else
			{
				frame.setJMenuBar(null);
				frame.validate();
			}
		}
		
	}
	
	class ActionColor implements ActionListener
	{
		 public void actionPerformed(ActionEvent e) 
	        {
			 String str = e.getActionCommand();
			 switch(str)
			 {
			 case "red" : data.clr = Color.red.getRGB(); break;
			 case "green" : data.clr = Color.green.getRGB(); break;
			 case "blue" : data.clr = Color.blue.getRGB(); break;
			 case "rainb" : data.clr = JColorChooser.showDialog(null, "Choose a color", new Color(data.clr)).getRGB(); break;
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
	
	class ActionSave implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent ev) 
		{
			JFileChooser fileSave = new JFileChooser();
			File file = new File("E:\\PaintVectorData");
			fileSave.setCurrentDirectory(file);
			fileSave.setDialogTitle("Сохранение файла");
			fileSave.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        int result = fileSave.showSaveDialog(null);
	        if (result == JFileChooser.APPROVE_OPTION )
	        {
	        	String extension = fileSave.getSelectedFile().getPath().replaceAll(".*\\.", "");
	        	switch(extension)
	        	{
	        	case "yaml" : doYaml(fileSave); break;
	        	case "csv"  : doCsv(fileSave);  break;
	        	case "json" : doJson(fileSave); break;
	        	case "xml"  : doXml(fileSave);  break;
	        	case "jpeg" : doJpeg(fileSave); break;
	        	default : break;
	        	}
	        }
		}
		public void doCsv(JFileChooser fileSave)
		{
			try {
				FileWriter output = new FileWriter(fileSave.getSelectedFile());
				
				String rs = "";
				int act = 0;
				for(int i = 0; i < ppnl.alpd.size(); i++)
				{
					if(ppnl.alpd.get(i) == ppnl.tabbedPane.getSelectedComponent())
						act = i;
				}
				for(PShape p:ppnl.alpd.get(act).pp)
				{
					int[] tmp = p.getParameters(); 
					String fig = "";
					switch(p.getClass().getName())
					{
					case "Shapes.PCurve"     : fig = "curve";          break;
					case "Shapes.PLine"      : fig = "line";           break;
					case "Shapes.PRect"      : fig = "rectangle";      break;
					case "Shapes.PRoundRect" : fig = "roundRectangle"; break;
					case "Shapes.POval"      : fig = "oval";           break;
					}
					rs += fig + "," + tmp[0] + "," + tmp[1] + "," + tmp[2] + "," + tmp[3] + "," + tmp[4] + "," + tmp[5] + "\n";
				}
				output.write(rs);
				output.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		public void doYaml(JFileChooser fileSave)
		{
			try {
				FileWriter output = new FileWriter(fileSave.getSelectedFile());
				
				String rs = "shapes:\n";
				int act = 0;
				for(int i = 0; i < ppnl.alpd.size(); i++)
				{
					if(ppnl.alpd.get(i) == ppnl.tabbedPane.getSelectedComponent())
						act = i;
				}
				for(PShape p:ppnl.alpd.get(act).pp)
				{
					int[] tmp = p.getParameters(); 
					String fig = "";
					switch(p.getClass().getName())
					{
					case "Shapes.PCurve"     : fig = "curve";          break;
					case "Shapes.PLine"      : fig = "line";           break;
					case "Shapes.PRect"      : fig = "rectangle";      break;
					case "Shapes.PRoundRect" : fig = "roundRectangle"; break;
					case "Shapes.POval"      : fig = "oval";           break;
					}
					rs += " - " + fig + ":\n" + "\tx: " + tmp[0] + "\n" + "\ty: " + tmp[1] + "\n" + "\tx2: " + tmp[2] + "\n" + "\ty2: " + tmp[3] + "\n" + "\tcolor: " + tmp[4] + "\n" + "\twidth: " + tmp[5] + "\n";
				}
				output.write(rs);
				output.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		public void doJson(JFileChooser fileSave)
		{
			try {
				FileWriter output = new FileWriter(fileSave.getSelectedFile());
				
				String rs = "{\"Shapes\":";
				int act = 0;
				for(int i = 0; i < ppnl.alpd.size(); i++)
				{
					if(ppnl.alpd.get(i) == ppnl.tabbedPane.getSelectedComponent())
						act = i;
				}
				for(PShape p:ppnl.alpd.get(act).pp)
				{
					int[] tmp = p.getParameters(); 
					String fig = "";
					switch(p.getClass().getName())
					{
					case "Shapes.PCurve"     : fig = "curve";          break;
					case "Shapes.PLine"      : fig = "line";           break;
					case "Shapes.PRect"      : fig = "rectangle";      break;
					case "Shapes.PRoundRect" : fig = "roundRectangle"; break;
					case "Shapes.POval"      : fig = "oval";           break;
					}
					rs += "{\"shape\":\"" + fig + "\",\"x\":" + tmp[0] + ",\"y\":" + tmp[1] + ",\"x2\":" + tmp[2] + ",\"y2\":" + tmp[3] + ",\"color\":" + tmp[4] + ",\"width\":" + tmp[5] + "}";
				}
				rs += "}";
				output.write(rs);
				output.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		public void doXml(JFileChooser fileSave)
		{
			try {
				DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	            Document document = documentBuilder.getDOMImplementation().createDocument("", "Shapes", null);
	            Node root = document.getDocumentElement();
	            int act = 0;
				for(int i = 0; i < ppnl.alpd.size(); i++)
				{
					if(ppnl.alpd.get(i) == ppnl.tabbedPane.getSelectedComponent())
						act = i;
				}
				for(PShape p:ppnl.alpd.get(act).pp)
				{
					int[] tmp = p.getParameters(); 
					String fig = "";
					switch(p.getClass().getName())
					{
					case "Shapes.PCurve"     : fig = "curve";          break;
					case "Shapes.PLine"      : fig = "line";           break;
					case "Shapes.PRect"      : fig = "rectangle";      break;
					case "Shapes.PRoundRect" : fig = "roundRectangle"; break;
					case "Shapes.POval"      : fig = "oval";           break;
					}
					Element shape = document.createElement(fig);
		         
		            Element x = document.createElement("x");	    
		            x.setTextContent(tmp[0]+"");	    		        
		            Element y = document.createElement("y");
		            y.setTextContent(tmp[1]+"");
		            Element x2 = document.createElement("x2");		    		          
		            x2.setTextContent(tmp[2]+"");	    		        
		            Element y2 = document.createElement("y2");
		            y2.setTextContent(tmp[3]+"");    		       
		            Element color = document.createElement("color");
		            color.setTextContent(tmp[4]+"");	    		  
		            Element width = document.createElement("width");
		            width.setTextContent(tmp[5]+"");

		            shape.appendChild(x);
		            shape.appendChild(y);
		            shape.appendChild(x2);
		            shape.appendChild(y2);
		            shape.appendChild(color);
		            shape.appendChild(width);
		            root.appendChild(shape);
		        }
				 	Transformer tr = TransformerFactory.newInstance().newTransformer();
		            DOMSource source = new DOMSource(document);
		            FileOutputStream fos = new FileOutputStream(fileSave.getSelectedFile());
		            StreamResult res = new StreamResult(fos);
		            tr.transform(source, res);
			} catch (ParserConfigurationException ex) 
            {
	            ex.printStackTrace(System.out);
	        } catch (IOException ex) 
	        {
	            ex.printStackTrace(System.out);
	        } catch (TransformerException e) 
			{
	            e.printStackTrace(System.out);
	        }
		}
		public void doJpeg(JFileChooser fileSave)
		{
			int act = 0;
			for(int i = 0; i < ppnl.alpd.size(); i++)
			{
				if(ppnl.alpd.get(i) == ppnl.tabbedPane.getSelectedComponent())
					act = i;
			}
			try {
				Graphics2D gg;
				if(ppnl.alpd.get(act).bi != null)
				{
					gg = (Graphics2D)ppnl.alpd.get(act).bi.getGraphics();
				} else
				{
					BufferedImage bi = new BufferedImage(760, 520, BufferedImage.SCALE_DEFAULT);
					gg = (Graphics2D)bi.getGraphics();
					gg.fillRect(0, 0, 760, 520);
				}
				for(PShape p:ppnl.alpd.get(act).pp)
				{
				p.draw(gg);
				}
				ImageIO.write(ppnl.alpd.get(act).bi, "jpeg", fileSave.getSelectedFile());
			}catch (IOException e) 
			{
				e.printStackTrace(System.out);
			}
		}
	}
	class ActionLoad implements ActionListener
	{
		int act = 0;
		
		@Override
		public void actionPerformed(ActionEvent ev) 
		{
			File file;
			String extension = "";
			JFileChooser fileopen = new JFileChooser();
			File Xfile = new File("E:\\PaintVectorData");
			fileopen.setCurrentDirectory(Xfile);
            int ret = fileopen.showDialog(null, "Открыть файл");                
            if (ret == JFileChooser.APPROVE_OPTION)
            {
            file = fileopen.getSelectedFile();
            extension = file.getName().replaceAll(".*\\.", "");
            try {
				 BufferedReader bufR = new BufferedReader(new FileReader(file.getPath()));
		         String res = "";
		         String temp = "";
		         while((temp = bufR.readLine()) != null)
		         {
		        	 res += temp + "\n";
		         }
					for(int i = 0; i < ppnl.alpd.size(); i++)
					{
						if(ppnl.alpd.get(i) == ppnl.tabbedPane.getSelectedComponent())
							act = i;
					}
					ppnl.alpd.get(act).pp = new ArrayList<PShape>();
				
	            switch(extension)
	            {
	            case "yaml" : doYaml(res);      break;
	            case "csv"  : doCsv(res);       break;
	            case "json" : doJson(res);      break;
	            case "xml"  : doXml(res, file); break;
	            case "jpeg" : doJpeg(file);     break;
	            default : break;
	            }
            } catch (IOException ex) 
	        {
	            ex.printStackTrace(System.out);
	        }
            }
		}
		public void doCsv(String res)
		{
			String[] figures = res.split("\n");
		    for(int i = 0; i < figures.length; i++)
		    {
		    	String[] actualFig = figures[i].split(",");
		    	int x = Integer.parseInt(actualFig[1]);
	    		int y = Integer.parseInt(actualFig[2]);
	    		int x2 = Integer.parseInt(actualFig[3]);
	    		int y2 = Integer.parseInt(actualFig[4]);
	    		int color = Integer.parseInt(actualFig[5]);
	    		int width = Integer.parseInt(actualFig[6]);
		    	switch(actualFig[0])
		    	{
		    	case "curve": 
		    		PCurve cur = new PCurve(x,y,x2,y2,color,width);
		    		ppnl.alpd.get(act).pp.add(cur);
		    		break;
		    	case "line": 
		    		PLine lin = new PLine(x,y,x2,y2,color,width); 
		    		ppnl.alpd.get(act).pp.add(lin);
		    		break;         
				case "rectangle": 
					PRect rec = new PRect(x,y,x2,y2,color,width); 
					ppnl.alpd.get(act).pp.add(rec);
					break;   
				case "roundRectangle": 
					PRoundRect rre = new PRoundRect(x,y,x2,y2,color,width);
					ppnl.alpd.get(act).pp.add(rre);
					break;
				case "oval": 
					POval ova = new POval(x,y,x2,y2,color,width);
					ppnl.alpd.get(act).pp.add(ova);
					break;
				default : break;
		    	}
		    }
		    ppnl.alpd.get(act).repaint();
		}
		public void doYaml(String res)
		{
			res = res.substring(8, res.length());
		    String[] figures = res.split(" - ");
		    for(int i = 1; i < figures.length; i++)
		    {
		    	String[] actualFig = figures[i].split("\n");
		    	int x = Integer.parseInt(actualFig[1].substring(4, actualFig[1].length()));
	    		int y = Integer.parseInt(actualFig[2].substring(4, actualFig[2].length()));
	    		int x2 = Integer.parseInt(actualFig[3].substring(5, actualFig[3].length()));
	    		int y2 = Integer.parseInt(actualFig[4].substring(5, actualFig[4].length()));
	    		int color = Integer.parseInt(actualFig[5].substring(8, actualFig[5].length()));
	    		int width = Integer.parseInt(actualFig[6].substring(8, actualFig[6].length()));
		    	switch(actualFig[0])
		    	{
		    	case "curve:": 
		    		PCurve cur = new PCurve(x,y,x2,y2,color,width);
		    		ppnl.alpd.get(act).pp.add(cur);
		    		break;
		    	case "line:": 
		    		PLine lin = new PLine(x,y,x2,y2,color,width); 
		    		ppnl.alpd.get(act).pp.add(lin);
		    		break;         
				case "rectangle:": 
					PRect rec = new PRect(x,y,x2,y2,color,width); 
					ppnl.alpd.get(act).pp.add(rec);
					break;   
				case "roundRectangle:": 
					PRoundRect rre = new PRoundRect(x,y,x2,y2,color,width);
					ppnl.alpd.get(act).pp.add(rre);
					break;
				case "oval:": 
					POval ova = new POval(x,y,x2,y2,color,width);
					ppnl.alpd.get(act).pp.add(ova);
					break;
				default : break;
		    	}
		    }
		    ppnl.alpd.get(act).repaint();
		}
		public void doJson(String res)
		{
			res = res.substring(10, res.length() - 1);
        	res = res.replaceAll("[}\"]", "");
		    String[] figures = res.split("\\{");
		    for(int i = 1; i < figures.length; i++)
		    {
		    	String[] actualFig = figures[i].split(",");
		    	int x = Integer.parseInt(actualFig[1].replaceAll(".+:", ""));
	    		int y = Integer.parseInt(actualFig[2].replaceAll(".+:", ""));
	    		int x2 = Integer.parseInt(actualFig[3].replaceAll(".+:", ""));
	    		int y2 = Integer.parseInt(actualFig[4].replaceAll(".+:", ""));
	    		int color = Integer.parseInt(actualFig[5].replaceAll(".+:", ""));
	    		int width = Integer.parseInt(actualFig[6].replaceAll(".+:", ""));
		    	switch(actualFig[0].replaceAll(".+:", ""))
		    	{
		    	case "curve": 
		    		PCurve cur = new PCurve(x,y,x2,y2,color,width);
		    		ppnl.alpd.get(act).pp.add(cur);
		    		break;
		    	case "line": 
		    		PLine lin = new PLine(x,y,x2,y2,color,width); 
		    		ppnl.alpd.get(act).pp.add(lin);
		    		break;         
				case "rectangle": 
					PRect rec = new PRect(x,y,x2,y2,color,width); 
					ppnl.alpd.get(act).pp.add(rec);
					break;   
				case "roundRectangle": 
					PRoundRect rre = new PRoundRect(x,y,x2,y2,color,width);
					ppnl.alpd.get(act).pp.add(rre);
					break;
				case "oval": 
					POval ova = new POval(x,y,x2,y2,color,width);
					ppnl.alpd.get(act).pp.add(ova);
					break;
				default : break;
		    	}
		    }
		    ppnl.alpd.get(act).repaint();
		}
		public void doXml(String res, File file)
		{
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file.getPath());
            Node root = document.getDocumentElement();
            NodeList shapes = root.getChildNodes();
            for (int i = 0; i < shapes.getLength(); i++) 
            {
                Node shape = shapes.item(i);
                if (shape.getNodeType() != Node.TEXT_NODE) 
                {
                    NodeList shapeData = shape.getChildNodes();
                    int x = Integer.parseInt(shapeData.item(0).getTextContent());
		    		int y = Integer.parseInt(shapeData.item(1).getTextContent());
		    		int x2 = Integer.parseInt(shapeData.item(2).getTextContent());
		    		int y2 = Integer.parseInt(shapeData.item(3).getTextContent());
		    		int color = Integer.parseInt(shapeData.item(4).getTextContent());
		    		int width = Integer.parseInt(shapeData.item(5).getTextContent());
		    		switch(shape.getNodeName())
			    	{
			    	case "curve": 
			    		PCurve cur = new PCurve(x,y,x2,y2,color,width);
			    		ppnl.alpd.get(act).pp.add(cur);
			    		break;
			    	case "line": 
			    		PLine lin = new PLine(x,y,x2,y2,color,width); 
			    		ppnl.alpd.get(act).pp.add(lin);
			    		break;         
					case "rectangle": 
						PRect rec = new PRect(x,y,x2,y2,color,width); 
						ppnl.alpd.get(act).pp.add(rec);
						break;   
					case "roundRectangle": 
						PRoundRect rre = new PRoundRect(x,y,x2,y2,color,width);
						ppnl.alpd.get(act).pp.add(rre);
						break;
					case "oval": 
						POval ova = new POval(x,y,x2,y2,color,width);
						ppnl.alpd.get(act).pp.add(ova);
						break;
					default : break;
			    	}
                }
            }
            ppnl.alpd.get(act).repaint();
		}catch (ParserConfigurationException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (IOException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) 
        {
            ex.printStackTrace(System.out);
        }
	}
		public void doJpeg(File file)
		{
			try {
					BufferedImage img = ImageIO.read(file);
					ppnl.alpd.get(act).bi = img;
					ppnl.alpd.get(act).repaint();
				}catch (IOException e) 
				{
					e.printStackTrace(System.out);
				}
		}
	}
	
	class PopupClass extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
        	openMenu(event);
        }

        public void mouseReleased(MouseEvent event)
        {
        	openMenu(event);
        }

        private void openMenu(MouseEvent event)
        {
            if (event.isPopupTrigger())
            {
            	new PContextMenu(cmd).popup.show(event.getComponent(),
                		event.getX(), event.getY());
            }
        }
    }
}
