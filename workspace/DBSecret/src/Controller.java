import java.net.URLDecoder;

import com.google.gson.Gson;

public class Controller {
    private DAO_SQL daoSQL = new DAO_SQL();
    private DAO daoFile = new DAO_File();

    public String execute(String id, String request) {
        String result = "";

        if (request.startsWith("API")) {
            Gson gson = new Gson();
            Request data = gson.fromJson(URLDecoder.decode(request.substring(3)), Request.class);

            switch (data.mode) {
                case "readOne":
                    result = daoSQL.read(id);
                    break;
                case "readAll":
                    result = daoSQL.read("pizza");
                    break;
                case "update":
                    daoSQL.update(id, data.secret);
                    result = "secret successfully updated";
                    break;
                case "deleteAcc":
                    daoSQL.delete(id);
                    result = "account successfully deleted'";
                    break;
                case "deleteSec":
                    daoSQL.update(id, "");
                    result = "secret successfully deleted";
                    break;
                case "signIn":
                    result = "ok";
                    break;
                case "signUp":
                    daoSQL.create(data.name, data.password);
                    result = "registered";
                    break;
            }
            if (result.equals(""))
                result = "gameIsUp";
        } else {
            result = daoFile.read(request);
        }

        return result;
    }
}
