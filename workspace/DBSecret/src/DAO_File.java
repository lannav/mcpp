import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class DAO_File implements DAO {
	private String direct;

	public DAO_File(){
		String separator = FileSystems.getDefault().getSeparator();
		direct = "E:" + separator + "xampp" + separator + "htdocs" + separator + "DBSecretJava" + separator;
	}

	@Override
	public void update(String filename, String value) {
		File file = new File(direct + filename);
		if(file.exists())
			create(filename, value);
	}

	@Override
	public String read(String filename) {
		if(filename.equals(""))
			filename = "index.html";
		File file = new File(direct + filename);
		try {
			byte[] bytes = Files.readAllBytes(file.toPath());
			return new String(bytes, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error";
	}

	@Override
	public void delete(String filename) {
		File file = new File(direct + filename);
		file.delete();
	}

	@Override
	public void create(String filename, String value) {
		File file = new File(direct + filename);
		if(!file.exists())
			try {
				FileWriter output = new FileWriter(file);
				output.write(value);
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
