
public class User {
	public final int id;
	public final String name;
	public final String password;
	public final String secret;

	public User(int id, String name, String password, String secret) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.secret = secret;
	}
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + password + ", " + secret;
	}
}
