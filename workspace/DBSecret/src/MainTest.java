import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class MainTest {

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(1, "vasia", "1111", "pupkin"));
		users.add(new User(2, "vasia", "1111", "pupkin"));
		users.add(new User(3, "vasia", "1111", "pupkin"));
		Gson gson = new Gson();
		String js = gson.toJson(users);
		System.out.println(js);
		User[] us = gson.fromJson(js, User[].class);
		
		for(User user:us) {
//			User Use = gson.fromJson(user, User.class);
			System.out.println(user.toString());
		}

//		File file = new File("C:\\xampp\\htdocs\\DBSecretJava\\zxzxzxzxzxzx.txt");
//		file.delete();
//		if(!file.exists())
//			try {
//				FileWriter output = new FileWriter(file);
//				output.write("jwahfiluahdgiulagfjkadg");
//				output.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
	}

}
