package IE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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

import blogic.Person;

public class ImplExp_XML implements ImplExp
{
	File file = null;
	ArrayList<Person> pp = null;
	
	public ImplExp_XML(File file, ArrayList<Person> pp)
	{
		this.file = file;
		this.pp = pp;
	}

	@Override
	public void save() 
	{
		try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("persons");
            document.appendChild(root);
            for(Person p:pp)
            {
            Element person = document.createElement("person");
            Element id = document.createElement("id");
            id.setTextContent(p.id+"");
            Element fname = document.createElement("fname");
            fname.setTextContent(p.fname);
            Element lname = document.createElement("lname");
            lname.setTextContent(p.lname);
            Element age = document.createElement("age");
            age.setTextContent(p.age+"");
            person.appendChild(id);
            person.appendChild(fname);
            person.appendChild(lname);
            person.appendChild(age);
            root.appendChild(person);
            }
            
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(file);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            
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

	@Override
	public ArrayList<Person> load() 
	{
		pp = new ArrayList<Person>();
		try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Node root = document.getDocumentElement();
            NodeList persons = root.getChildNodes();
            for (int i = 0; i < persons.getLength(); i++) 
            {
                Node person = persons.item(i);
                if (person.getNodeType() != Node.TEXT_NODE) 
                {
                    NodeList personData = person.getChildNodes();
                    Person p = new Person(Integer.parseInt(personData.item(0).getTextContent()),personData.item(1).getTextContent(),
                    		personData.item(2).getTextContent(),Integer.parseInt(personData.item(3).getTextContent()));
                    pp.add(p);
                }
            }
        } catch (ParserConfigurationException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) 
        {
            ex.printStackTrace(System.out);
        } catch (IOException ex) 
        {
            ex.printStackTrace(System.out);
        }
		return pp;
	}

}
