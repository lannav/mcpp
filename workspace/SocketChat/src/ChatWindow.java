import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChatWindow extends JPanel {
    private JLabel lable = new JLabel();
    private JTextField field = new JTextField();
    public ChatWindow(Client client) {
        setLayout(null);
        setBounds(10, 10, 280, 480);
        JScrollPane sp = new JScrollPane(lable);

            sp.setBounds(0, 0, 265, 380);
        add(sp);
        field.setBounds(0,385, 240, 60);
        add(field);
        JButton send = new JButton("send");
        send.setBounds(245,385, 20, 60);
        ActionListener listener = (event) -> {
            if (!field.getText().equals("")) {
                client.message = field.getText();
                lable.setText("<html>" + lable.getText() + "<br/>" + field.getText() + "<html/>");
                client.message = lable.getText();

                sp.getViewport().setViewPosition(new Point(0, sp.getViewport().getView().getHeight()));
            }
        };
        send.addActionListener(listener);
        add(send);
    }
}
