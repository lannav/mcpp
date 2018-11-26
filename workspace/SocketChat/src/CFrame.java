import javax.swing.*;

public class CFrame extends JFrame {
    public CFrame(String clientName, Client client) {
        setLayout(null);
        setTitle(clientName);
        setBounds(100, 100, 300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new ChatWindow(client));
        setVisible(true);
    }
}