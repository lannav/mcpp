import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    String message = null;
    public Client() throws IOException {
        Socket s = new Socket("localhost", 9090);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        new CFrame("Client1", this);
        while (true) {
            out.println(message);
            message = null;
            String answer = input.toString();
        }
    }

}
