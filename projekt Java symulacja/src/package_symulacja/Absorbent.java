package package_symulacja;


import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Absorbent extends JComponent {

	int width;
	int shading = 1;
	Color c0 = Color.gray;
	Color c1 = Color.LIGHT_GRAY;
	
	public Absorbent(int shade) {
		width = 14;
		shade = shading;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(shading == 1) {
			c0 = Color.GRAY;
			c1 = Color.LIGHT_GRAY;
		}
		else if(shading == 2) {
			c0 = new Color(148, 90, 36);
			c1 = new Color(217, 135, 58);
		}
		else if(shading == 3) {
			c0 = Color.DARK_GRAY;
			c1 = Color.GRAY;
		}
		Graphics2D g2 = (Graphics2D)g;
		Rectangle2D absorbent = new Rectangle2D.Double(getWidth()/2 - width/2, 5, width, getHeight());
		Rectangle2D absorbentEdge = new Rectangle2D.Double(getWidth()/2 - width/2, 5, width, getHeight()-6);
		GradientPaint gp = new GradientPaint(0, 0, c0, 50, 0, c1, true);
	    g2.setPaint(gp);
	    g2.fill(absorbent);
	    g2.setColor(Color.black);
	    g2.setStroke(new BasicStroke(1));
	    g2.draw(absorbentEdge);
//		g.setColor(Color.gray);
//		g.fillRect(getWidth()/2 - width/2, 5, width, getHeight());

	}
}

