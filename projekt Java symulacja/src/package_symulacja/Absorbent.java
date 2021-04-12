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
		g.setColor(Color.black);
		g.fillRect(245 - width/2, 25, width, 255);

	}
}
