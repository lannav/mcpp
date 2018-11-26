
public class Request {
	public final String name;
	public final String password;
	public final String secret;
	public final String mode;

	public Request(String name, String password, String secret, String mode) {
		this.name = name;
		this.password = password;
		this.secret = secret;
		this.mode = mode;
	}
}
