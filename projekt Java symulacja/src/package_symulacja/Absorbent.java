package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class Absorbent extends JComponent {

	int width;
	public Absorbent() {
		width = 10;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.gray);
		g.fillRect(getWidth()/2 - width/2, 5, width, getHeight());

	}
}
