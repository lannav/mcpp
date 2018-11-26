import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class MyButton extends JButton 
{
	 private static final double ARC_WIDTH  = 50d;
	    private static final double ARC_HEIGHT = 50d;
	    protected static final int FOCUS_STROKE = 2;
	    protected final Color fc = new Color(100, 150, 255, 200);
	    protected final Color ac = new Color(230, 230, 230);
	    protected final Color rc = Color.ORANGE;
	    protected Shape shape;
	    protected Shape border;
	    protected Shape base;
	    protected MyButton() {
	        super();
	    }
	    protected MyButton(String text) {
	        super(text);
	    }
	    @Override public void updateUI() {
	        super.updateUI();
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	        initShape();
	    }
	    protected void initShape() {
	        if (!getBounds().equals(base)) {
	            base = getBounds();
	            shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT);
	        }
	    }
	    @Override protected void paintComponent(Graphics g) {
	        initShape();
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        if (getModel().isArmed()) {
	            g2.setPaint(ac);
	            g2.fill(shape);
	        } else {
	            g2.setPaint(getBackground());
	            g2.fill(shape);
	        }
	        g2.dispose();
	        super.paintComponent(g);
	    }
}
