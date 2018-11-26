import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

public class Main {
	
	public static void main(String[] args)
	{
		try {
			HttpServer server = HttpServer.create();
			server.bind(new InetSocketAddress(8765), 1);
			HttpContext context = server.createContext("/", EchoHandler.getInstance());
			context.setAuthenticator(Auth.getInstance());
	        server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}