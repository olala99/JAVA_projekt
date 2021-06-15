/* panel centralny:
 * panel z tlem do animacji
 * panel z przyciskami kontrolujacymi AnimationControlPanel */

package package_symulacja;




import static java.util.concurrent.TimeUnit.MILLISECONDS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.*;

public class AnimationPanel extends JPanel {
	Random rand = new Random();
	JPanel animationPanel;
	Absorbent absorbent;
	int licznik = 0;
	
	private static final long serialVersionUID = 1L;
	List<EnergyParticle> particles = new ArrayList<EnergyParticle>();
	int incr = 1;
	int iteracja = 0;
	ScheduledExecutorService scheduler;	
	
	public void addEnergyParticle(int x, int y, Color c, int absorbentThickness, double absorbentType, int vx){
		EnergyParticle particle = new EnergyParticle();
		particle.setX(x);
		particle.setY(y);
		particle.setColor(c);
		
		for (int i = 0; i < absorbentThickness  ; i++) {
			double randomNumber = rand.nextDouble();
		
			if(Math.exp(-absorbentType) < randomNumber) {
				particle.setVisible(false);
				licznik++;
				i = absorbentThickness;
			}
		}
		
		particles.add(particle);		
	}
	
	public void testParticle(int y,Color c ) {
		EnergyParticle testParticle = new EnergyParticle();
		testParticle.setX(-700);
		testParticle.setY(y);
		testParticle.setColor(c);
		testParticle.setVX(6);
		particles.add(testParticle);
	}
	
	
	void moveParticles(boolean particlesAreMoving) {
		 
		if(particlesAreMoving == false) {
			
			scheduler = Executors
					.newScheduledThreadPool(2);
		
			scheduler.scheduleAtFixedRate((new Runnable() {

			@Override
			public void run() {
				for (EnergyParticle ep : particles){
		         		 ep.setX( ep.getX() + ep.getVX());

		         		if(ep.getX() + 8 >= getWidth()/2 && !ep.getVisible()) {
		         			 ep.removeParticle(getBackground());
		         		}
					if(particles.get(1000).getX() >= getWidth()) {
						System.out.println("particles " + particles.get(1000).getX());
						particles.clear();
							
						repaint();
						scheduler.shutdown();
					}    		
				}
				
				repaint();

			}
			}), 0, 100, MILLISECONDS);
			
		}
		
		if(particlesAreMoving == true) {
			scheduler.shutdown();
			
		}
		
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (EnergyParticle ep : particles) {
			ep.paint(g);
		}
	}
	
	public AnimationPanel() {
	
		this.setLayout(new BorderLayout());
		absorbent = new Absorbent(1);
		this.add(absorbent);
		this.setBackground(Color.white);	
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
}

