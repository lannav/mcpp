import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

class Auth extends Authenticator {
	private ArrayList<String> validPages = new ArrayList<>();
    private ArrayList<String> regularAccess = new ArrayList<>();
	private HashMap<Long, String> map = new HashMap<>();
	private static Auth instance = null;
    private HttpExchange exchange;


	public Auth() {
		validPages.add("/index.html");
		validPages.add("/user.html");
		validPages.add("/admin.html");
		validPages.add("/phpRequest.js");
		validPages.add("/");

        regularAccess.add("/index.html");
        regularAccess.add("/phpRequest.js");
        regularAccess.add("/");
	}

    @Override
    public Result authenticate(HttpExchange httpExchange) {
        this.exchange = httpExchange;
	    cleanMap();
        EchoHandler.getInstance().setResponse("");
        String request = httpExchange.getRequestURI().toString();

        if (validPages.contains(request)) {
            if(!regularAccess.contains(request) && getToken() == 0)
                EchoHandler.getInstance().setResponse("gameIsUp");

            return new Success(new HttpPrincipal("c0nst", "realm"));
        }else if(request.startsWith("/API")) {
            Gson gson = new Gson();
            String mode = gson.fromJson(URLDecoder.decode(request.substring(4)), Request.class).mode;
            if(!mode.substring(0,4).equals("sign") && getToken() == 0)
                EchoHandler.getInstance().setResponse("gameIsUp");

            if(mode.substring(0,4).equals("sign")) {
                User user = userIsExist(request.substring(1));
                switch (mode.substring(4, 6)) {
                    case "In":
                        if (user == null)
                            EchoHandler.getInstance().setResponse("gameIsUp");
                        else {
                            long UID = System.currentTimeMillis() + 300000;
                            map.put(UID, user.id + "");
                            EchoHandler.getInstance().setCookie("UID", UID + "", 300000, exchange);
                        }
                        break;
                    case "Up":
                        if (user != null)
                            EchoHandler.getInstance().setResponse("userExist");
                        break;
                }
            }

            return new Success(new HttpPrincipal("c0nst", "realm"));
        }

        return new Failure(418);
    }

	public String getID() {
		String id = map.get(getToken());
		if (id != null)
			return id;
		else
            return null;
	}

	public long getToken() {
		String token = EchoHandler.getInstance().getCookie("UID", exchange);
		if(token != null) {
            String uid = map.get(Long.parseLong(token));
            if(uid != null)
                return Long.parseLong(token);
            else
                return 0;
        }
		else
		    return 0;
	}

	private User userIsExist(String request){
		DAO daoSQL = new DAO_SQL();
		Gson gson = new Gson();

		Request data = gson.fromJson(URLDecoder.decode(request.substring(3)), Request.class);
		String jsonUsers = daoSQL.read("pizza");
		User[] users = gson.fromJson(jsonUsers, User[].class);

		for (User user : users)
			if (data.name.equals(user.name) && data.password.equals(user.password))
				return user;

		return null;
	}

	private void cleanMap() {
        long time = System.currentTimeMillis();
        for (Map.Entry<Long, String> entry : map.entrySet())
            if (entry.getKey() < time)
                map.remove(entry.getKey());
    }

    public static Auth getInstance() {
	    if(instance == null)
	        instance = new Auth();

	    return instance;
    }
}