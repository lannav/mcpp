package blogic;

import java.io.File;
import java.util.ArrayList;
import IE.ImplExp;
import IE.ImplExp_CSV;
import IE.ImplExp_JSON;
import IE.ImplExp_XML;
import IE.ImplExp_YAML;

public class IESelect 
{
	ImplExp ie;
	
	ImplExp getIE(File file, ArrayList<Person> pp)
	{
			String extension = file.getName();
			extension.toLowerCase();
			if(extension.endsWith("yaml"))
				ie = new ImplExp_YAML(file, pp);
			else if(extension.endsWith("json"))
				ie = new ImplExp_JSON(file, pp);
			else if(extension.endsWith("xml"))
				ie = new ImplExp_XML(file, pp);
			else if(extension.endsWith("csv"))
				ie = new ImplExp_CSV(file, pp);
        
		return ie;
	}
}
