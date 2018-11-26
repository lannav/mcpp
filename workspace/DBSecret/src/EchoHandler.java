import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class EchoHandler implements HttpHandler {

	private static EchoHandler instance = null;
	private Controller controller = new Controller();
	private String response = "";

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		StringBuilder builder = new StringBuilder();

        if(response.equals(""))
            builder.append(controller.execute(Auth.getInstance().getID(), exchange.getRequestURI().toString().substring(1)));
        else
            builder.append(response);

		byte[] bytes = builder.toString().getBytes();
		exchange.sendResponseHeaders(200, bytes.length);
		OutputStream os = exchange.getResponseBody();
		os.write(bytes);
		os.close();
	}
	
	public static EchoHandler getInstance()
	{
		if(instance == null)
			instance = new EchoHandler();
		
		return instance;	
	}
	
	public void setCookie(String name, String value, long lifeTime, HttpExchange exchange) {
		Headers respHeaders = exchange.getResponseHeaders();
		List<String> values = new ArrayList<>();
		values.add(name + "=" + value + "; version=1; Path=/; Max-Age=" + (10800 + lifeTime/1000) + "; HttpOnly");
		respHeaders.put("Set-Cookie", values);
	}

	public String getCookie(String name, HttpExchange exchange){
		List<String> cookie = exchange.getRequestHeaders().get("Cookie");
		if (cookie != null)
			for (String cook : cookie)
				if (cook.substring(0, name.length()).equals(name))
					return cook.substring(name.length()+1);

		return null;
	}

	public void setResponse(String response) {
	    this.response = response;
    }
}
